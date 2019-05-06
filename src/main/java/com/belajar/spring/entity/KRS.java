package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KRS {

    private int id_krs;
    private String namaMataKuliah;

    public KRS() {
    }

    public KRS(int id) {
        this.id_krs = id_krs;
    }

}
