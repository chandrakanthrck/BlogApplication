package com.codewithck.blog.BlogApplication.services.impl;

import com.codewithck.blog.BlogApplication.entities.Category;
import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.entities.User;
import com.codewithck.blog.BlogApplication.exceptions.ResourceNotFoundException;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.repository.CategoryRepo;
import com.codewithck.blog.BlogApplication.repository.PostRepo;
import com.codewithck.blog.BlogApplication.repository.UserRepo;
import com.codewithck.blog.BlogApplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Post updatePost(PostDTO postDTO, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
