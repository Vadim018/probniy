package com.example.probniy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.probniy.entity.Users;
import java.util.List;
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByUsername(String name);
    Users findByUsername(String name);
}