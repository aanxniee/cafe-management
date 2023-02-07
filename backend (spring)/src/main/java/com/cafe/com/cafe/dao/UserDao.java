package com.cafe.com.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cafe.com.cafe.modal.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
