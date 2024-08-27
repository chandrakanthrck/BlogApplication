package com.codewithck.blog.BlogApplication.services;

import com.codewithck.blog.BlogApplication.payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);

}
