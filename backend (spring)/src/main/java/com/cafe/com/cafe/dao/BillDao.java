package com.cafe.com.cafe.dao;

import com.cafe.com.cafe.modal.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDao extends JpaRepository<Bill, Integer> {
}
