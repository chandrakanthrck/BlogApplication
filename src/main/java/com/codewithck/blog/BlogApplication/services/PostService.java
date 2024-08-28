package com.codewithck.blog.BlogApplication.services;

import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.repository.PostRepo;

import java.util.List;

public interface PostService {
    //create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    //update
    Post updatePost(PostDTO postDTO, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    List<Post> getAllPost();
    //get single post
    Post getPostById(Integer postId);
    //get all post by category
    List<PostDTO> getPostsByCategory(Integer categoryId);
    //get all posts by user
    List<PostDTO> getPostsByUser(Integer userId);
    //search posts
    List<PostDTO> searchPosts(String keyword);
}
