package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public ResponseEntity<List<User>> showAll() {
        List<User> userList = userService.findALl();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> register(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            if (userService.findUsernameExits(user.getUsername())) {
                return new ResponseEntity<>("Tài khoản đã tồn tại", HttpStatus.BAD_REQUEST);
            } else if (userService.findEmailExits(user.getEmail())) {
                return new ResponseEntity<>("Email đã tồn tại", HttpStatus.BAD_REQUEST);
            } else if (!user.getPassword().equals(user.getConfirmPassword())) {
                return new ResponseEntity<>("Mật khẩu không trùng khớp", HttpStatus.BAD_REQUEST);
            } else {
                userService.save(user);
                return new ResponseEntity<>("Đăng ký thành công", HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@Validated @RequestBody User user, @PathVariable Long id, BindingResult bindingResult) {
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody User user) {
            User currentUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (!userService.findUsernameExits(user.getUsername())) {
                return new ResponseEntity<>("Tài khoản chưa được đăng ký", HttpStatus.BAD_REQUEST);
            } else if (currentUser == null) {
                return new ResponseEntity<>("Mật khẩu không đúng", HttpStatus.BAD_REQUEST);
            } else{
                return new ResponseEntity<>(currentUser, HttpStatus.OK);
            }
        }
}
