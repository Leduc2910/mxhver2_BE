package com.codegym.service;

import com.codegym.model.Status;
import com.codegym.repository.StatusRepository;
import com.codegym.service.intf.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public List<Status> findALl() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }
}
