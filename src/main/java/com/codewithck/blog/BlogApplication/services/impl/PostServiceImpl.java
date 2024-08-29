package com.codewithck.blog.BlogApplication.services.impl;

import com.codewithck.blog.BlogApplication.entities.Category;
import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.entities.User;
import com.codewithck.blog.BlogApplication.exceptions.ResourceNotFoundException;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.payload.PostResponse;
import com.codewithck.blog.BlogApplication.repository.CategoryRepo;
import com.codewithck.blog.BlogApplication.repository.PostRepo;
import com.codewithck.blog.BlogApplication.repository.UserRepo;
import com.codewithck.blog.BlogApplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        //to get user for post
        User user = userRepo.findById(String.valueOf(userId)).orElseThrow(
                () -> new ResourceNotFoundException("User", "User Id", userId)
        );
        //to get category for post
        Category category = categoryRepo.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Category Id", categoryId)
        );
        Post post = modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = postRepo.save(post);
        return modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post", "Post Id", postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageName(postDTO.getImageName());
        Post updatedPost = postRepo.save(post);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post", "Post Id", postId));
        postRepo.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {
        //call pageable to get which page and page size
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = postRepo.findAll(pageable);
        List<Post> allPosts = pagePost.getContent();
        List<PostDTO> allPostsDTO = allPosts.stream().map(post ->
                modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        //setting post response
        postResponse.setContent(allPostsDTO);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getNumberOfElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post postById = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "Post Id", postId));
        return modelMapper.map(postById, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Category Id", categoryId)
        );
        List<Post> posts = postRepo.findByCategory(category);
        List<PostDTO> postDTOS = posts.stream().map(
                (post) -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        User user = userRepo.findById(String.valueOf(userId)).orElseThrow(
                () -> new ResourceNotFoundException("User", "User Id", userId)
        );
        List<Post> posts = postRepo.findByUser(user);
        List<PostDTO> postDTOS = posts.stream().map(
                post -> modelMapper.map(post, PostDTO.class)).toList();
        return postDTOS;
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        return null;
    }
}
