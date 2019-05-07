package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class Student implements Serializable {

    private int id_student;

    private String name;

    private String address;

    private String namaJurusan;

    private String fakultas;

    private String jurusan_id;


    public Student() {

    }

    public Student(int id_student, String name, String address,String namaJurusan,String fakultas,String jurusan_id) {
        this.id_student = id_student;
        this.name = name;
        this.address = address;
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
        this.jurusan_id = jurusan_id;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan_id(){
        return jurusan_id;
    }

    public void setJurusan_id(String jurusan_id){
        this.jurusan_id = jurusan_id;
    }
    @Override
    public String   toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", namaJurusan='" + namaJurusan + '\'' +
                ", fakultas='" + fakultas + '\'' +
                ", jurusan_id='" + jurusan_id + '\'' +
                '}';
    }



}
