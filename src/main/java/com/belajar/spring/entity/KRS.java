package com.belajar.spring.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Krs implements Serializable {


    private int id_krs;
    private String namaJurusan;
    private String fakultas;

    public Krs() {

    }

    public int getId_krs() {
        return id_krs;
    }

    public void setId_krs(int id_krs) {
        this.id_krs = id_krs;
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
    public String toString() {
        return "Student{" +
                "id_krs=='" + id_krs +
                ", namaJurusan='" + namaJurusan + '\'' +
                ", fakultas='" + fakultas + '\'' +
                '}';
    }

    public Krs(int id_krs, String namaJurusan, String fakultas) {
        this.id_krs = id_krs;
        this.namaJurusan = namaJurusan;
        this.fakultas = fakultas;
    }
}

