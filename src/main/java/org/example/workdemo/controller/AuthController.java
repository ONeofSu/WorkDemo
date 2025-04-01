package org.example.workdemo.controller;

import org.example.workdemo.CommonResponse;
import org.example.workdemo.entity.User;
import org.example.workdemo.security.JwtUtil;
import org.example.workdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CommonResponse commonResponse;

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        if(userService.login(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok()
                    .body(commonResponse.build("登录成功", 0, jwtUtil.generateToken(user.getUsername())));
        } else {
            return ResponseEntity.status(401)
                    .body(commonResponse.build("用户名或密码错误", 1));
        }

    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, Object>> users(@RequestBody User user) {
        if (userService.register(user.getUsername(),user.getPassword())) {
            return ResponseEntity.ok()
                    .body(commonResponse.build("注册成功", 0));
        } else {
            return ResponseEntity.status(409)
                    .body(commonResponse.build("注册失败", 1));
        }
    }
}
