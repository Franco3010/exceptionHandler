package com.example.api.demo.spring.boot.controller;

import com.example.api.demo.spring.boot.dto.UserCreateRequest;
import com.example.api.demo.spring.boot.dto.UserUpdateRequest;
import com.example.api.demo.spring.boot.dto.response.ApiResponse;
import com.example.api.demo.spring.boot.entity.User;
import com.example.api.demo.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreateRequest request) {
        System.out.println("helloW");
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/{userId}")
    ApiResponse<User> getUser(@PathVariable("userId") String userId) {
        ApiResponse apiResponse = new ApiResponse();
        User user = userService.getUser(userId);
        apiResponse.setResult(user);
        return apiResponse;
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
