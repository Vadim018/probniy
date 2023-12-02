package com.example.probniy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.probniy.entity.Customer;
import com.example.probniy.entity.Role;
import com.example.probniy.entity.Users;
import com.example.probniy.repository.CustomerRepository;
import com.example.probniy.repository.UserManagerRepository;
import com.example.probniy.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserManagerService implements UserDetailsService, UserManagerRepository {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserManagerService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public boolean getLogicByUser(String username)
    {
        return !userRepository.findAllByUsername(username).isEmpty();
    }

    public Users saveNewUserToDB(Users user) {
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_User")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<Customer> getCustomerList()
    {
        return customerRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user1 = userRepository.findByUsername(username);
        System.out.println(user1);
        if (user1 == null) {
            throw new UsernameNotFoundException("Користувача не знайдено!");
        }
        return user1;
    }

    @Override
    public void deleteUserById(Long userId) {
        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            customerRepository.deleteById(userId);
            userRepository.delete(user);
        } else {
            throw new IllegalArgumentException("Користувача з таким id: " + userId + " не знайдено.");
        }
    }
}