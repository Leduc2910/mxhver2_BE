package com.codegym.service;

import com.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);
    void delete(Long id);
    List<User> findALl();
    Optional<User> findById(Long id);
    boolean findUsernameExits(String username);
    boolean findEmailExits(String email);
    User findByUsernameAndPassword(String username,String password);
}
