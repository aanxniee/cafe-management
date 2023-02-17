package com.cafe.com.cafe.rest;

import com.cafe.com.cafe.modal.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/bill")
public interface BillRest {

    @PostMapping(path = "/generateReport")
    public ResponseEntity<String> generateReport(@RequestBody(required = true) Map<String, Object> requestMap);

    @GetMapping(path = "/getBills")
    public ResponseEntity<List<Bill>> getBills();
}
