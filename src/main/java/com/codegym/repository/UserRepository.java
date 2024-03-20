package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByUsernameAndPassword(String username, String password);
}
