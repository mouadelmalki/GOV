package com.appsp.Oncf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.AffichageService;
import com.appsp.Oncf.models.Affichage;


@RestController
@RequestMapping("/affichage")
public class AffichageController {

    @Autowired
    private AffichageService affichageService;

    @GetMapping("/{id}")
    public Affichage getAffichage(@PathVariable int id) {
        return affichageService.getAffichage(id);
    }

    @PostMapping
    public Affichage createAffichage(@RequestBody Affichage affichage) {
        return affichageService.createAffichage(affichage);
    }

    @PutMapping("/{id}")
    public Affichage updateAffichage(@PathVariable int id, @RequestBody Affichage affichage) {
        affichage.setId(id);
        return affichageService.updateAffichage(affichage);
    }

    @DeleteMapping("/{id}")
    public void deleteAffichage(@PathVariable int id) {
        affichageService.deleteAffichage(id);
    }
}

