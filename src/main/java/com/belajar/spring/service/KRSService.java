package com.belajar.spring.service;

import com.belajar.spring.entity.KRS;

import java.util.List;

public interface KRSService extends BaseService<KRS> {
    List<KRS> findByName(KRS param);
}

