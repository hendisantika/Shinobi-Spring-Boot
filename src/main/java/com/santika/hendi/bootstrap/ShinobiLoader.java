/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santika.hendi.bootstrap;

import com.santika.hendi.domain.Shinobi;
import com.santika.hendi.repositories.ShinobiRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author hendi.santika
 */
@Component
public class ShinobiLoader implements ApplicationListener<ContextRefreshedEvent>{
    private ShinobiRepository shinobiRepository;
    
    private Logger log = Logger.getLogger(ShinobiLoader.class);

    @Autowired
    public void setShinobiRepository(ShinobiRepository shinobiRepository) {
        this.shinobiRepository = shinobiRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Shinobi shinobi = new Shinobi();
        shinobi.setNama("Uzumaki Naruto");
        shinobi.setLevel("Hokage");
        shinobi.setJutsu("Rasengan");
        shinobi.setDesa("Konohagakure");
        shinobiRepository.save(shinobi);
        
                
        log.info("Saved Shinobi - id: " + shinobi.getId());

        Shinobi shinobi2 = new Shinobi();
        shinobi.setNama("Uchiha Sasuke");
        shinobi.setLevel("Rogue Ninja");
        shinobi.setJutsu("Chidori");
        shinobi.setDesa("Konohagakure");
        shinobiRepository.save(shinobi2);

        log.info("Saved Shinobi - id:" + shinobi2.getId());
        
        Shinobi shinobi3 = new Shinobi();
        shinobi.setNama("Haruno Sakura");
        shinobi.setLevel("Jounin");
        shinobi.setJutsu("Sanaro");
        shinobi.setDesa("Konohagakure");
        shinobiRepository.save(shinobi3);

        log.info("Saved Shinobi - id:" + shinobi3.getId());

        Shinobi shinobi4 = new Shinobi();
        shinobi.setNama("Hatake Kakashi");
        shinobi.setLevel("Jounin");
        shinobi.setJutsu("Raikiri");
        shinobi.setDesa("Konohagakure");
        shinobiRepository.save(shinobi4);

        log.info("Saved Shinobi - id:" + shinobi4.getId());
    }
    
    
}
