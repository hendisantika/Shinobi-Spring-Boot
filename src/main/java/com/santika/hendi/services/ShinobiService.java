/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santika.hendi.services;

import com.santika.hendi.domain.Shinobi;

/**
 *
 * @author hendi.santika
 */
public interface ShinobiService {
    Iterable<Shinobi> listAllShinobis();
    
    Shinobi getShinobiById(Integer id);
    
    Shinobi saveShinobi(Shinobi shinobi);
    
    void deleteShinobi(Integer id);
}
