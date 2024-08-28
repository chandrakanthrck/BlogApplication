package com.codewithck.blog.BlogApplication.controllers;

import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.payload.PostDTO;
import com.codewithck.blog.BlogApplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
