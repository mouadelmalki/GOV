package com.appsp.Oncf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.AffectationVoieService;
import com.appsp.Oncf.models.AffectationVoie;

@RestController
@RequestMapping("/affectation_voie")
public class AffectationVoieController {

    @Autowired
    private AffectationVoieService affectationVoieService;

    @GetMapping("/{id}")
    public AffectationVoie getAffectationVoieById(@PathVariable int id) {
        return affectationVoieService.getAffectationVoieById(id);
    }

    @PostMapping("/")
    public AffectationVoie createAffectationVoie(@RequestBody AffectationVoie affectationVoie) {
        return affectationVoieService.createAffectationVoie(affectationVoie);
    }

    @PutMapping("/{id}")
    public AffectationVoie updateAffectationVoie(@PathVariable int id, @RequestBody AffectationVoie affectationVoie) {
        return affectationVoieService.updateAffectationVoie(id, affectationVoie);
    }

    @DeleteMapping("/{id}")
    public void deleteAffectationVoie(@PathVariable int id) {
        affectationVoieService.deleteAffectationVoie(id);
    }
}

