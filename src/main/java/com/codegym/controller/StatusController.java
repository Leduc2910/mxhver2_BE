package com.codegym.controller;

import com.codegym.model.Status;
import com.codegym.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("status")
@CrossOrigin("*")
public class StatusController {
    @Autowired
    private StatusServiceImpl statusService;

    @GetMapping()
    public ResponseEntity<List<Status>> showAll() {
        List<Status> statusList = statusService.findALl();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Status status) {
        statusService.save(status);
        return new ResponseEntity<>("Đăng thành công", HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@RequestBody Status status, @PathVariable Long id) {
        status.setId(id);
        statusService.save(status);
        return new ResponseEntity<>("Chỉnh sửa thành công", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        statusService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
