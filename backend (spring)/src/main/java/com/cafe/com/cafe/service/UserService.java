package com.cafe.com.cafe.service;

import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface UserService {
    // user sign up api
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
