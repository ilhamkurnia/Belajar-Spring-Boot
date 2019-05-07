
package com.belajar.spring.entity;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Dosen implements Serializable {
    private int id_dosen;

    private String name;

    private String address;

    public Dosen() {
    }

    public int getId_dosen() {
        return id_dosen;
    }

    public void setId_dosen(int id_dosen) {
        this.id_dosen = id_dosen;
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


    @Override
    public String   toString() {
        return "Student{" +
                "id_dosen=" + id_dosen +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Dosen(int id_dosen) {
        this.id_dosen = id_dosen;
    }

    public Dosen(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Dosen(int id_dosen, String name, String address) {
        this.id_dosen = id_dosen;
        this.name = name;
        this.address = address;
    }
}
