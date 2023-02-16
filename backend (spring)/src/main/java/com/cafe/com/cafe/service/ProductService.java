package com.cafe.com.cafe.service;

import com.cafe.com.cafe.modal.Product;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

public interface ProductService {
    // adds new product to a category api
    ResponseEntity<String> addNewProduct(Map<String, String> requestMap);

    // ResponseEntity<List<Product>> getAllProducts(String filterValue);
    // ResponseEntity<String> updateProduct(Map<String, String> requestMap);

}
