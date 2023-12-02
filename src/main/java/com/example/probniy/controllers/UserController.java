package com.example.probniy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.probniy.service.CustomerManagerService;
import com.example.probniy.service.UserManagerService;
import com.example.probniy.service.UserService;

@Controller
public class UserController {
    public UserManagerService userManagerService;
    public UserService userService;
    public CustomerManagerService customerManagerService;
    @Autowired
    public UserController(UserManagerService userManagerService, UserService userService, CustomerManagerService customerManagerService) {
        this.userManagerService = userManagerService;
        this.userService = userService;
        this.customerManagerService = customerManagerService;
    }
}