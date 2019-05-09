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

    private int idDosen;
    private String nameDosen;

    private int idKrs;
    private String nameJurusan;
    private String nameFakultas;

    public Student() {

    }

    public Student(int idStudent, String nameStudent, String addressStudent, int idDosen, String nameDosen,int idKrs
    , String nameJurusan ,String nameFakultas) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.addressStudent = addressStudent;
        this.idDosen = idDosen;
        this.idKrs =idKrs;
        this.nameDosen = nameDosen;
        this.nameJurusan = nameJurusan;
        this.nameFakultas = nameFakultas;
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

    public int getIdDosen(){
        return idDosen;
    }

    public void setIdDosen(int idDosen){
        this.idDosen = idDosen;
    }
    public int getIdKrs(){ return idKrs; }

    public void setIdKrs(int idKrs){
        this.idKrs = idKrs;
    }
    public String getNameJurusan(){
        return nameJurusan;
    }
    public void setNameJurusan(String nameJurusan){
        this.nameJurusan = nameJurusan;
    }
    public String getNameFakultas(){
        return nameFakultas;
    }
    public void setNameFakultas(){
        this.nameFakultas = nameFakultas;
    }

    @Override
    public String   toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", addressStudent='" + addressStudent + '\'' +
                ", idDosen='" + idDosen + '\'' +
                ", nameDosen='" + nameDosen + '\'' +
                ", idKrs='" + idKrs + '\'' +
                ", nameJurusan='" + nameJurusan + '\'' +
                ", nameFakultas='"+ nameFakultas +'\'' +
                '}';
    }



}
