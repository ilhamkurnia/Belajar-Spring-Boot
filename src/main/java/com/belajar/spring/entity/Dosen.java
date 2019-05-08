
package com.belajar.spring.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Dosen implements Serializable {
    private int idDosen;

    private String nameDosen;

    private String addressDosen;

    public Dosen() {
    }

    public int getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(int idDosen) {
        this.idDosen = idDosen;
    }

    public String getNameDosen() {
        return nameDosen;
    }

    public void setNameDosen(String nameDosen) {
        this.nameDosen = nameDosen;
    }

    public String getAddressDosen() {
        return addressDosen;
    }

    public void setAddressDosen(String addressDosen) {
        this.addressDosen = addressDosen;
    }


    @Override
    public String   toString() {
        return "Student{" +
                "idDosen=" + idDosen +
                ", nameDosen='" + nameDosen + '\'' +
                ", addressDosen='" + addressDosen + '\'' +
                '}';
    }

    public Dosen(int idDosen) {
        this.idDosen = idDosen;
    }

    public Dosen(String nameDosen, String addressDosen) {
        this.nameDosen = nameDosen;
        this.addressDosen = addressDosen;
    }

    public Dosen(int idDosen, String nameDosen, String addressDosen) {
        this.idDosen = idDosen;
        this.nameDosen = nameDosen;
        this.addressDosen = addressDosen;
    }
}
