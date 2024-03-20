package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @GetMapping()
    public ResponseEntity<List<Comment>> showAll() {
        List<Comment> commentList = commentService.findALl();
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<>("Đăng thành công", HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@RequestBody Comment comment, @PathVariable Long id) {
        comment.setId(id);
        commentService.save(comment);
        return new ResponseEntity<>("Chỉnh sửa thành công", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        commentService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
