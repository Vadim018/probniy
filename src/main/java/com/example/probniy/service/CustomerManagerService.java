package com.example.probniy.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import com.example.probniy.entity.Customer;
import com.example.probniy.entity.Users;
import com.example.probniy.repository.CustomerRepository;

@Service
public class CustomerManagerService {
    private final CustomerRepository customerRepository;

    public CustomerManagerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUsername(@NotNull Users users) {
        return customerRepository.findById(users.getId()).get();
    }

    public void saveCustomerToDB(Customer customer) {
        customerRepository.save(customer);
    }
}