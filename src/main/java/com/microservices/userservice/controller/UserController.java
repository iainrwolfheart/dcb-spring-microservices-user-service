package com.microservices.userservice.controller;

import com.microservices.userservice.ValueObjects.ResponseTemplateVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") String userId) {
        return userService.findUserWithDepartment(userId);
    }

}
