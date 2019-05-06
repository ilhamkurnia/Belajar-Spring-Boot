/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar.spring.controller;

import com.belajar.spring.entity.Dosen;
import com.belajar.spring.entity.Student;
import com.belajar.spring.service.DosenService;
import com.belajar.spring.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class DosenControlller {
    
    @Autowired
    private DosenService service;

    @GetMapping(value = "/dosen")
    public List<Dosen> dosen() {
        return service.find();
    }

    @GetMapping(value = "/dosen/{id}")
    public Dosen findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/dosen")
    public String save(@RequestBody Dosen dosen) {
        Dosen data = service.save(dosen);
        if (data.getIdDosen() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/dosen")
    public String update(@RequestBody Dosen dosen) {
        Dosen data = service.update(dosen);
        if (data.getIdDosen() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/dosen/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new Dosen(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
