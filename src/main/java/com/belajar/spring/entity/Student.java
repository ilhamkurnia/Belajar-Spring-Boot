package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */
@Getter
@Setter
public class Student implements Serializable {

    private int id;

    private String name;

    private String address;
    private String kodeMataKuliah;
    
    private String namaMataKuliah;
    
        private String nameDosen;
      
   
    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, String address,String kodeMataKuliah,String namaMataKuliah) {
        this.name = name;
        this.address = address;
        this.kodeMataKuliah = kodeMataKuliah;
        this.namaMataKuliah =namaMataKuliah;
    }

    public Student(int id, String name,String address,String kodeMataKuliah,String namaMataKuliah) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.namaMataKuliah = namaMataKuliah;
    }



}
