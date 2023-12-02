package com.example.probniy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.probniy.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}