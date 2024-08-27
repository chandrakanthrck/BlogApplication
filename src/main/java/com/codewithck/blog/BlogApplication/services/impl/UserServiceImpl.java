package com.codewithck.blog.BlogApplication.services.impl;

import com.codewithck.blog.BlogApplication.entities.User;
import com.codewithck.blog.BlogApplication.exceptions.ResourceNotFoundException;
import com.codewithck.blog.BlogApplication.payload.UserDTO;
import com.codewithck.blog.BlogApplication.repository.UserRepo;
import com.codewithck.blog.BlogApplication.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        User savedUser = userRepo.save(user);
        return objectMapper.convertValue(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = userRepo.findById(String.valueOf(userId)).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        User updatedUser = userRepo.save(user);
        return objectMapper.convertValue(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = userRepo.findById(String.valueOf(userId)).
                orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));
        return objectMapper.convertValue(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> objectMapper.
                convertValue(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(String.valueOf(userId)).
                orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        userRepo.delete(user);
    }
}
