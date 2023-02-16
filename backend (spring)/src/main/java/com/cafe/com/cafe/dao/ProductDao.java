package com.cafe.com.cafe.dao;

import com.cafe.com.cafe.modal.Product;
import com.cafe.com.cafe.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<ProductWrapper> getAllProduct();
}
