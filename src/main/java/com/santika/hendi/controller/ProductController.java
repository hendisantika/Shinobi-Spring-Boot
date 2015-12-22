package com.santika.hendi.controller;

import com.santika.hendi.domain.Shinobi;
import com.santika.hendi.services.ShinobiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ShinobiService shinobiService;

    @Autowired
    public void setShinobiService(ShinobiService shinobiService) {
        this.shinobiService = shinobiService;
    }
    
    @RequestMapping(value = "/shinobis", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("shinobis", shinobiService.listAllShinobis());
        return "shinobis";
    }


    @RequestMapping("shinobi/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("shinobi", shinobiService.getShinobiById(id));
        return "shinobishow";
    }

    @RequestMapping("shinobi/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("shinobi", shinobiService.getShinobiById(id));
        return "shinobiform";
    }

    @RequestMapping("shinobi/new")
    public String newProduct(Model model){
        model.addAttribute("shinobi", new Shinobi());
        return "shinobiform";
    }

    @RequestMapping(value = "shinobi", method = RequestMethod.POST)
    public String saveProduct(Shinobi shinobi){
        shinobiService.saveShinobi(shinobi);
        return "redirect:/shinobi/" + shinobi.getId();
    }

    @RequestMapping("shinobi/delete/{id}")
    public String delete(@PathVariable Integer id){
        shinobiService.deleteShinobi(id);
        return "redirect:/shinobis";
    }

}
