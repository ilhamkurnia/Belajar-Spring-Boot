
package com.belajar.spring.service.impl;


import com.belajar.spring.dao.KRSDAO;

import java.util.List;

import com.belajar.spring.entity.KRS;
import com.belajar.spring.service.KRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KRSServiceImpl implements KRSService {

    @Autowired
    private KRSDAO krsDAO;


    @Override
    public KRS save(KRS param) {
        return krsDAO.save(param);
    }

    @Override
    public KRS update(KRS param) {
        return krsDAO.update(param);
    }

    @Override
    public int delete(KRS param) {
        return krsDAO.delete(param);
    }

    @Override
    public List<KRS> find() {
        List<KRS>  krs = krsDAO.find();
        for (KRS data : krs){
            data.setIdKrs(data.getIdKrs());
        }

        return krs;
    }

    @Override
    public KRS findById(int id) {
        return krsDAO.findById(id);
    }




    @Override
    public List<KRS> findByName(KRS param){
        return krsDAO.findByName(param);
    }

}
