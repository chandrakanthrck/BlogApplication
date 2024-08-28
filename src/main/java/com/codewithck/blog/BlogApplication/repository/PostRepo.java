package com.codewithck.blog.BlogApplication.repository;

import com.codewithck.blog.BlogApplication.entities.Category;
import com.codewithck.blog.BlogApplication.entities.Post;
import com.codewithck.blog.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    //finding posts by user and category
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
