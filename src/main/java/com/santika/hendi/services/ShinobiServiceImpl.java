/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santika.hendi.services;

import com.santika.hendi.domain.Shinobi;
import com.santika.hendi.repositories.ShinobiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hendi.santika
 */
@Service
public class ShinobiServiceImpl implements ShinobiService{
    private ShinobiRepository shinobiRepository;

    @Autowired
    public void setShinobiRepository(ShinobiRepository shinobiRepository) {
        this.shinobiRepository = shinobiRepository;
    }

    @Override
    public Iterable<Shinobi> listAllShinobis() {
        return shinobiRepository.findAll();
    }

    @Override
    public Shinobi getShinobiById(Integer id) {
        return shinobiRepository.findById(id).get();
    }

    @Override
    public Shinobi saveShinobi(Shinobi shinobi) {
        return shinobiRepository.save(shinobi);
    }

    @Override
    public void deleteShinobi(Integer id) {
        shinobiRepository.deleteById(id);
    }
    
    
}
