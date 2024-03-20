package com.codegym.service.serviceImpl;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findALl() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean findUsernameExits(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean findEmailExits(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }
}
