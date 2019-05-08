package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class Student implements Serializable {

    private int idStudent;

    private String nameStudent;

    private String addressStudent;

    private String namaJurusan;

    private String fakultas;


    public Student() {

    }

    public Student(int idStudent, String nameStudent, String addressStudent, String namaJurusan, String fakultas) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.addressStudent = addressStudent;
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getAddressStudent() {
        return addressStudent;
    }

    public void setAddressStudent(String addressStudent) {
        this.addressStudent = addressStudent;
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

    @Override
    public String   toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", addressStudent='" + addressStudent + '\'' +
                ", namaJurusan='" + namaJurusan + '\'' +
                ", fakultas='" + fakultas + '\'' +
                '}';
    }



}
