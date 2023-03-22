/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santika.hendi.bootstrap;

import com.santika.hendi.domain.Shinobi;
import com.santika.hendi.repositories.ShinobiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(ShinobiLoader.class);

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
        shinobi2.setNama("Uchiha Sasuke");
        shinobi2.setLevel("Rogue Ninja");
        shinobi2.setJutsu("Chidori");
        shinobi2.setDesa("Konohagakure");
        shinobiRepository.save(shinobi2);

        log.info("Saved Shinobi - id:" + shinobi2.getId());
        
        Shinobi shinobi3 = new Shinobi();
        shinobi3.setNama("Haruno Sakura");
        shinobi3.setLevel("Jounin");
        shinobi3.setJutsu("Sanaro");
        shinobi3.setDesa("Konohagakure");
        shinobiRepository.save(shinobi3);

        log.info("Saved Shinobi - id:" + shinobi3.getId());

        Shinobi shinobi4 = new Shinobi();
        shinobi4.setNama("Hatake Kakashi");
        shinobi4.setLevel("Jounin");
        shinobi4.setJutsu("Raikiri");
        shinobi4.setDesa("Konohagakure");
        shinobiRepository.save(shinobi4);

        log.info("Saved Shinobi - id:" + shinobi4.getId());
    }
    
    
}
