package com.belajar.spring.dao;

import com.belajar.spring.entity.Krs;

import java.util.List;

public interface KrsDAO extends BaseDAO<Krs> {
    Krs findById(int id);

    List<Krs> findByName(Krs param);



}
