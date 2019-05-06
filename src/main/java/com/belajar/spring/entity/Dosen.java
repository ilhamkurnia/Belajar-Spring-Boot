/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ACER i3
 */
@Getter
@Setter
<<<<<<< HEAD
public class Dosen implements Serializable{
=======
public class Dosen implements Serializable {
>>>>>>> first
    private int idDosen;

    private String nameDosen;

    private String addressDosen;

    private String mataKuliah;
<<<<<<< HEAD
    
=======

>>>>>>> first

    //private List<KRS> krs;

    public Dosen() {
    }

    public Dosen(int idDosen) {
        this.idDosen = idDosen;
    }

    public Dosen(String nameDosen, String addressDosen, String mataKuliah) {
        this.nameDosen = nameDosen;
        this.addressDosen = addressDosen;
        this.mataKuliah = mataKuliah;
    }

<<<<<<< HEAD
    public Dosen (int idDosen, String nameDosen, String addressDosen, String mataKuliah) {
=======
    public Dosen(int idDosen, String nameDosen, String addressDosen, String mataKuliah) {
>>>>>>> first
        this.idDosen = idDosen;
        this.nameDosen = nameDosen;
        this.addressDosen = addressDosen;
        this.mataKuliah = mataKuliah;
    }
<<<<<<< HEAD
=======

    public Object getIdDosen() {
        return idDosen;
    }

>>>>>>> first
}
