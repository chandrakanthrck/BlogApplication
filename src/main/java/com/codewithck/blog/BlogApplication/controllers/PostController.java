package com.codewithck.blog.BlogApplication.controllers;

import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.payload.ApiResponse;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
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
    @GetMapping("posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        List<PostDTO> getPosts = postService.getAllPost();
        return new ResponseEntity<>(getPosts, HttpStatus.OK);
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
