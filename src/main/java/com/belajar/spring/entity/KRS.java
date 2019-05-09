package com.belajar.spring.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Krs implements Serializable {


    private int idKrs;
    private String nameJurusan;
    private String nameFakultas;

    public Krs() {

    }

    public int getIdKrs() {
        return idKrs;
    }

    public void setIdKrs(int idKrs) {
        this.idKrs = idKrs;
    }


    public String getNameJurusan() {
        return nameJurusan;
    }

    public void setNameJurusan(String nameJurusan) {
        this.nameJurusan = nameJurusan;
    }

    public String getNameFakultas() {
        return nameFakultas;
    }

    public void setNameFakultas(String nameFakultas) {
        this.nameFakultas = nameFakultas;
    }


    @Override
    public String toString() {
        return "Student{" +
                "idKrs=='" + idKrs +
                ", nameJurusan='" + nameJurusan + '\'' +
                ", nameFakultas='" + nameFakultas + '\'' +
                '}';
    }

    public Krs(int idKrs, String nameJurusan, String nameFakultas) {
        this.idKrs = idKrs;
        this.nameJurusan = nameJurusan;
        this.nameFakultas = nameFakultas;
    }
}

