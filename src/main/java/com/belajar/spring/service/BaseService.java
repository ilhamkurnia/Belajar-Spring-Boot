package com.belajar.spring.service;

import java.util.List;


public interface BaseService<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    List<T> find();

    T findById(int id);

}
