package com.cafe.com.cafe.dao;

import com.cafe.com.cafe.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cafe.com.cafe.modal.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmailId(@Param("email") String email);

    List<UserWrapper> getAllUser();
}
