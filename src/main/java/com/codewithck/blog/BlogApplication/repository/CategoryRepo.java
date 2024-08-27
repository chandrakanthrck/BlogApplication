package com.codewithck.blog.BlogApplication.repository;

import com.codewithck.blog.BlogApplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
