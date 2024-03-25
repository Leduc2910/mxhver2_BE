package com.codegym.service.intf;

import com.codegym.model.User;
import com.codegym.service.intf.IService;

import java.util.List;
import java.util.Optional;

public interface UserService extends IService<User> {
    boolean findUsernameExits(String username);
    User findUsername(String username);
    boolean findEmailExits(String email);
    User findByUsernameAndPassword(String username,String password);
}
