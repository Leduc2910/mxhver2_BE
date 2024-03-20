package com.codegym.service.serviceImpl;

import com.codegym.model.Status;
import com.codegym.service.StatusService;

import java.util.List;
import java.util.Optional;

public class StatusServiceImpl implements StatusService {
    @Override
    public void save(Status status) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Status> findALl() {
        return null;
    }

    @Override
    public Optional<Status> findById(Long id) {
        return Optional.empty();
    }
}
