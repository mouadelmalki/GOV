package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationAgentPService;
import com.appsp.Oncf.models.AffectationAgentP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectations_agent_p")
public class AffectationAgentPController {

    @Autowired
    private AffectationAgentPService affectationAgentPService;

    // Créer une affectation agent P

    @PostMapping
    public ResponseEntity<AffectationAgentP> creerAffectationAgentP(@RequestBody AffectationAgentP affectationAgentP) {
        AffectationAgentP nouvelleAffectationAgentP = affectationAgentPService.creerAffectationAgentP(affectationAgentP);
        return new ResponseEntity<>(nouvelleAffectationAgentP, HttpStatus.CREATED);
    }
    // Récupérer toutes les affectations agents P

    @GetMapping
    public ResponseEntity<List<AffectationAgentP>> recupererToutesLesAffectationsAgentsP() {
        List<AffectationAgentP> affectationsAgentsP = affectationAgentPService.recupererToutesLesAffectationsAgentsP();
        return new ResponseEntity<>(affectationsAgentsP, HttpStatus.OK);
    }

// Récupérer une affectation agent P par son ID

    @GetMapping("/{id}")
    public ResponseEntity<AffectationAgentP> recupererAffectationAgentPParId(@PathVariable("id") int id) {
        Optional<AffectationAgentP> affectationAgentP = affectationAgentPService.recupererAffectationAgentPParId(id);
        return affectationAgentP.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

// Mettre à jour une affectation agent P

    @PutMapping("/{id}")
    public ResponseEntity<AffectationAgentP> mettreAJourAffectationAgentP(@PathVariable("id") int id, @RequestBody AffectationAgentP affectationAgentP) {
        Optional<AffectationAgentP> affectationAgentPExistant = affectationAgentPService.recupererAffectationAgentPParId(id);
        if (affectationAgentPExistant.isPresent()) {
            affectationAgentP.setId_AffectP(id);
            AffectationAgentP affectationAgentPMisAJour = affectationAgentPService.mettreAJourAffectationAgentP(affectationAgentP);
            return new ResponseEntity<>(affectationAgentPMisAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

// Supprimer une affectation agent P

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> supprimerAffectationAgentP(@PathVariable("id") int id) {
        Optional<AffectationAgentP> affectationAgentP = affectationAgentPService.recupererAffectationAgentPParId(id);
        if (affectationAgentP.isPresent()) {
            affectationAgentPService.supprimerAffectationAgentP(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


