package com.codegym.service;

import com.codegym.model.UsedImage;
import com.codegym.repository.UsedImageRepository;
import com.codegym.service.intf.UsedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsedImageServiceImpl implements UsedImageService {
    @Autowired
    private UsedImageRepository usedImageRepository;
    @Override
    public void save(UsedImage usedImage) {
        usedImageRepository.save(usedImage);
    }

    @Override
    public void delete(Long id) {
        usedImageRepository.deleteById(id);
    }

    @Override
    public List<UsedImage> findALl() {
        return usedImageRepository.findAll();
    }

    @Override
    public Optional<UsedImage> findById(Long id) {
        return usedImageRepository.findById(id);
    }
}
