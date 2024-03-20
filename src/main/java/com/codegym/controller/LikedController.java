package com.codegym.controller;

import com.codegym.model.Liked;
import com.codegym.model.UsedImage;
import com.codegym.service.LikedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("like")
@CrossOrigin("*")
public class LikedController {
    @Autowired
    private LikedServiceImpl likedService;
    @GetMapping()
    public ResponseEntity<List<Liked>> showAll() {
        List<Liked> likedList = likedService.findALl();
        return new ResponseEntity<>(likedList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Liked liked) {
        likedService.save(liked);
        return new ResponseEntity<>("Đăng thành công", HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@RequestBody Liked liked, @PathVariable Long id) {
        liked.setId(id);
        likedService.save(liked);
        return new ResponseEntity<>("Chỉnh sửa thành công", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        likedService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
