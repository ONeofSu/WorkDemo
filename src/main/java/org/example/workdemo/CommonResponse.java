package org.example.workdemo;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommonResponse {

    public Map<String, Object> build(String message, int code) {
        return Map.of("message", message, "code", code);
    }

    public Map<String, Object> build(String message, int code, String accessToken) {
        return Map.of("message", message, "code", code, "access_token", accessToken);
    }
}
