package org.example.workdemo.controller;

import org.example.workdemo.entity.User;
import org.example.workdemo.security.JwtUtil;
import org.example.workdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth/login")
    public String login(@RequestBody User user) {
        if(userService.login(user.getUsername(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        return "Invalid username or password";
    }

    @PostMapping("/users")
    public void users(@RequestBody User user) {
        userService.register(user.getUsername(),user.getPassword());
    }
}
