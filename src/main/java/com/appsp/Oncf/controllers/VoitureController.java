package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.VoitureService;
import com.appsp.Oncf.models.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

    @GetMapping("/{id}")
    public Voiture getVoitureById(@PathVariable int id) {
        return voitureService.getVoitureById(id);
    }

    @PostMapping
    public Voiture saveVoiture(@RequestBody Voiture voiture) {
        return voitureService.saveVoiture(voiture);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable int id) {
        voitureService.deleteVoiture(id);
    }
}

