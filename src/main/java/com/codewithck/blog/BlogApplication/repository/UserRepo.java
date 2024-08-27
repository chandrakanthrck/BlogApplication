package com.codewithck.blog.BlogApplication.repository;

import com.codewithck.blog.BlogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

}
