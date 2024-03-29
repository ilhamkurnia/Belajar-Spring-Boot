package com.belajar.spring.service.impl;

import com.belajar.spring.dao.StudentDAO;
import com.belajar.spring.entity.Student;
import com.belajar.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;


    @Override
    public Student save(Student param) {
        return studentDAO.save(param);
    }

    @Override
    public Student update(Student param) {
        return studentDAO.update(param);
    }

    @Override
    public int delete(Student param) {
        return studentDAO.delete(param);
    }

    @Override
    public List<Student> find() {
        List<Student> students = studentDAO.find();
        for (Student data : students){
            data.setIdStudent(data.getIdStudent());
        }
        return students;

    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findByName(Student param) {
        return studentDAO.findByName(param);
    }
}
