package com.codegym.controller;

import com.codegym.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

}
