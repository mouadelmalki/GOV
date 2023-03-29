package com.appsp.Oncf.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.AffichageService;
import com.appsp.Oncf.models.Affichage;

import java.util.List;
import java.util.Optional;

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

