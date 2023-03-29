package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.VoieService;
import com.appsp.Oncf.models.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voie")
public class VoieController {

    private final VoieService voieService;

    public VoieController(VoieService voieService) {
        this.voieService = voieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voie> getVoieById(@PathVariable int id) {
        Voie voie = voieService.getVoieById(id);
        if (voie == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(voie);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Voie> createVoie(@RequestBody Voie voie) {
        Voie createdVoie = voieService.createVoie(voie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVoie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voie> updateVoie(@PathVariable int id, @RequestBody Voie voie) {
        Voie updatedVoie = voieService.updateVoie(id, voie);
        if (updatedVoie == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedVoie);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoie(@PathVariable int id) {
        boolean deleted = voieService.deleteVoie(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
