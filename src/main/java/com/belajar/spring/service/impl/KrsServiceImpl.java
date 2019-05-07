
package com.belajar.spring.service.impl;


import com.belajar.spring.dao.KrsDAO;

import java.util.List;

import com.belajar.spring.entity.Krs;
import com.belajar.spring.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KrsServiceImpl implements KrsService {

    @Autowired
    private KrsDAO krsDAO;


    @Override
    public Krs save(Krs param) {
        return krsDAO.save(param);
    }

    @Override
    public Krs update(Krs param) {
        return krsDAO.update(param);
    }

    @Override
    public int delete(Krs param) {
        return krsDAO.delete(param);
    }

    @Override
    public List<Krs> find() {
        List<Krs>  krs = krsDAO.find();
        for (Krs data : krs){
            data.setId_krs(data.getId_krs());
        }

        return krs;
    }

    @Override
    public Krs findById(int id) {
        return krsDAO.findById(id);
    }




    @Override
    public List<Krs> findByName(Krs param){
        return krsDAO.findByName(param);
    }

}
