package com.santika.hendi.repositories;

import com.santika.hendi.configuration.RepositoryConfiguration;
import com.santika.hendi.domain.Shinobi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ShinobiRepositoryTest {

    private ShinobiRepository shinobiRepository;

    @Autowired
      public void setShinobiRepository(ShinobiRepository shinobiRepository) {
        this.shinobiRepository = shinobiRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup product
        Shinobi shinobi = new Shinobi();
        shinobi.setNama("Momochi Zabusa");
        shinobi.setLevel("Rogue Ninja");
        shinobi.setJutsu("Sakabato");
        shinobi.setDesa("Kirigakure");

        //save product, verify has ID value after save
        assertNull(shinobi.getId()); //null before save
        shinobiRepository.save(shinobi);
        assertNotNull(shinobi.getId()); //not null after save

        //fetch from DB
        Shinobi fetchedShinobi = shinobiRepository.findOne(shinobi.getId());

        //should not be null
        assertNotNull(fetchedShinobi);

        //should equal
        assertEquals(shinobi.getId(), fetchedShinobi.getId());
        assertEquals(shinobi.getNama(), fetchedShinobi.getNama());

        //update description and save
        fetchedShinobi.setJutsu("Byakugan");
        shinobiRepository.save(fetchedShinobi);

        //get from DB, should be updated
        Shinobi fetchedUpdatedShinnobi = shinobiRepository.findOne(fetchedShinobi.getId());
        assertEquals(fetchedShinobi.getLevel(), fetchedUpdatedShinnobi.getLevel());

        //verify count of products in DB
        long shinobiCount = shinobiRepository.count();
        assertEquals(shinobiCount, 1);

        //get all products, list should only have one
        Iterable<Shinobi> shinobis = shinobiRepository.findAll();

        int count = 0;

        for(Shinobi s : shinobis){
            count++;
        }

        assertEquals(count, 1);
    }

  
}
