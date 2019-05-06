package com.belajar.spring.service.impl;

import com.belajar.spring.dao.KRSDAO;
import com.belajar.spring.dao.DosenDao;
import com.belajar.spring.entity.Dosen;
import com.belajar.spring.service.DosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DosenServiceImpl implements DosenService {

    @Autowired
    private DosenDao dosenDAO;

    @Autowired
    private KRSDAO krsdao;

    @Override
    public Dosen save(Dosen param) {
        return dosenDAO.save(param);
    }

    @Override
    public Dosen update(Dosen param) {
        return dosenDAO.update(param);
    }

    @Override
    public int delete(Dosen param) {
        return dosenDAO.delete(param);
    }

    @Override
    public List<Dosen> find() {
        List<Dosen> dosen = dosenDAO.find();
        for (Dosen data : dosen){
            
        }

        return dosen;
    }

    @Override
    public Dosen findById(int id) {
        return dosenDAO.findById(id);
    }


}
