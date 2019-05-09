package com.belajar.spring.dao;

import com.belajar.spring.entity.KRS;

import java.util.List;

public interface KRSDAO extends BaseDAO<KRS> {
    KRS findById(int id);

    List<KRS> findByName(KRS param);



}
