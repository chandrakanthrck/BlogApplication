package com.codewithck.blog.BlogApplication.controllers;

import com.codewithck.blog.BlogApplication.payload.ApiResponse;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.payload.PostResponse;
import com.codewithck.blog.BlogApplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDTO createPost = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId){
        List<PostDTO> getPosts = postService.getPostsByUser(userId);
        return new ResponseEntity<>(getPosts, HttpStatus.OK);
    }

    //get by category
    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDTO> getPosts = postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(getPosts, HttpStatus.OK);
    }

    //get all posts
    //adding pagination
    @GetMapping("posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir){
        PostResponse postResponse = postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //get post by postid
    @GetMapping("posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO getPost = postService.getPostById(postId);
        return new ResponseEntity<>(getPost, HttpStatus.OK);
    }

    @DeleteMapping("posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted!", true);
    }

    @PutMapping("posts/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postId){
        PostDTO updatePost = postService.updatePost(postDTO ,postId);
        return  new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
    }

}
