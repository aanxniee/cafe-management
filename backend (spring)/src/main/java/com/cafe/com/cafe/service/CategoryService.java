package com.cafe.com.cafe.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CategoryService {

    // adds new item to the category
    ResponseEntity<String> addNewCategory(Map<String, String> requestMap);
}
