package com.codegym.controller;

import com.codegym.model.Status;
import com.codegym.model.UsedImage;
import com.codegym.service.UsedImageServiceImpl;
import com.codegym.service.intf.UsedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("image")
@CrossOrigin("*")
public class UsedImageController {
    @Autowired
    private UsedImageServiceImpl usedImageService;
    @GetMapping()
    public ResponseEntity<List<UsedImage>> showAll() {
        List<UsedImage> usedImageList = usedImageService.findALl();
        return new ResponseEntity<>(usedImageList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UsedImage usedImage) {
        usedImageService.save(usedImage);
        return new ResponseEntity<>("Đăng thành công", HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@RequestBody UsedImage usedImage, @PathVariable Long id) {
        usedImage.setId(id);
        usedImageService.save(usedImage);
        return new ResponseEntity<>("Chỉnh sửa thành công", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usedImageService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
