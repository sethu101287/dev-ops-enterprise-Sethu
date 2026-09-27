package com.enterprise.sethu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final Map<Long, Map<String, Object>> customers = new ConcurrentHashMap<>();
    private long sequence = 1L;

    public CustomerController() {
        seedCustomers();
    }

    private void seedCustomers() {
        createCustomer("Alpha Logistics", "ALPHA-1001", "ACTIVE");
        createCustomer("Beta Manufacturing", "BETA-2002", "ACTIVE");
        createCustomer("Gamma Retail", "GAMMA-3003", "PENDING");
    }

    private void createCustomer(String name, String customerCode, String status) {
        long id = sequence++;
        Map<String, Object> customer = new ConcurrentHashMap<>();
        customer.put("id", id);
        customer.put("name", name);
        customer.put("customerCode", customerCode);
        customer.put("status", status);
        customer.put("region", "EMEA");
        customers.put(id, customer);
    }

    @GetMapping("/customers")
    public List<Map<String, Object>> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Map<String, Object>> getCustomer(@PathVariable long id) {
        Map<String, Object> customer = customers.get(id);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Customer not found"));
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/customers")
    public ResponseEntity<Map<String, Object>> createCustomer(@RequestBody Map<String, Object> request) {
        String name = Objects.toString(request.get("name"), "");
        String customerCode = Objects.toString(request.get("customerCode"), "");
        String status = Objects.toString(request.get("status"), "ACTIVE");

        if (name.isBlank() || customerCode.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "name and customerCode are required"));
        }

        long id = sequence++;
        Map<String, Object> customer = new ConcurrentHashMap<>();
        customer.put("id", id);
        customer.put("name", name);
        customer.put("customerCode", customerCode);
        customer.put("status", status);
        customer.put("region", Objects.toString(request.getOrDefault("region", "NA"), "NA"));
        customers.put(id, customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
