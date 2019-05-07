
package com.belajar.spring.service;

import com.belajar.spring.entity.Dosen;

import java.util.List;

public interface DosenService extends BaseService<Dosen> {
    List<Dosen> findByName (Dosen param);
}
