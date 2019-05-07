
package com.belajar.spring.dao;

import com.belajar.spring.entity.Dosen;

import java.util.List;


public interface DosenDAO extends BaseDAO<Dosen> {
    List<Dosen> findByName (Dosen param);
}