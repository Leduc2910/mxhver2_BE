package com.codegym.service;

import com.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findALl();
    Optional<E> findById(Long id);
}
