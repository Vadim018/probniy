package com.example.probniy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.probniy.entity.Users;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByUsernameAndPassword(String username, String pass);
    Users findByUsernameAndPassword(String user, String pass);
}