package com.cafe.com.cafe.dao;

import com.cafe.com.cafe.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
