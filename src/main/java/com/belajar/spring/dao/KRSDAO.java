package com.belajar.spring.dao;

import com.belajar.spring.entity.KRS;

import java.util.List;

public interface KRSDAO extends BaseDAO<KRS> {

    List<KRS> findByStudentId(int id);

<<<<<<< HEAD
    public List<KRS> findByDosenId(int id);
=======
    List<KRS> findByDosenId(int id);
>>>>>>> first

}
