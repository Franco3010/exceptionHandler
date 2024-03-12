package com.example.api.demo.spring.boot.service;

import com.example.api.demo.spring.boot.dto.UserCreateRequest;
import com.example.api.demo.spring.boot.dto.UserUpdateRequest;
import com.example.api.demo.spring.boot.entity.User;
import com.example.api.demo.spring.boot.exception.EntityNotFoundException;
import com.example.api.demo.spring.boot.exception.ErrorCode;
import com.example.api.demo.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(UserCreateRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        logger.info("object",user);
        return userRepository.save(user);
    }


    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_EXISTED.getCode(), ErrorCode.USER_NOT_EXISTED.getMessage()));
    }
}
