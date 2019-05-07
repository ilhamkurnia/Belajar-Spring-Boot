package com.belajar.spring.service;

import com.belajar.spring.entity.Krs;

import java.util.List;

public interface KrsService extends BaseService<Krs> {
    List<Krs> findByName(Krs param);
}

