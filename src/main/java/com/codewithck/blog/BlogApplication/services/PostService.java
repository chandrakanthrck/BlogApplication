package com.codewithck.blog.BlogApplication.services;

import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.payload.PostResponse;
import com.codewithck.blog.BlogApplication.repository.PostRepo;

import java.util.List;

public interface PostService {
    //create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    //update
    PostDTO updatePost(PostDTO postDTO, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize);
    //get single post
    PostDTO getPostById(Integer postId);
    //get all post by category
    List<PostDTO> getPostsByCategory(Integer categoryId);
    //get all posts by user
    List<PostDTO> getPostsByUser(Integer userId);
    //search posts
    List<PostDTO> searchPosts(String keyword);
}
