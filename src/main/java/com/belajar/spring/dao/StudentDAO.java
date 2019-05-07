package com.belajar.spring.dao;

import com.belajar.spring.entity.Student;

import java.util.List;


public interface StudentDAO extends BaseDAO<Student> {
    List<Student> findByName(Student param);
}
