package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationAgentRService;
import com.appsp.Oncf.models.AffectationAgentR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectationsAgentR")
public class AffectationAgentRController {

    @Autowired
    private AffectationAgentRService affectationAgentRService;

    @PostMapping
    public ResponseEntity<AffectationAgentR> creerAffectationAgentR(@RequestBody AffectationAgentR affectationAgentR) {
        AffectationAgentR nouvelleAffectationAgentR = affectationAgentRService.creerAffectationAgentR(affectationAgentR);
        return new ResponseEntity<>(nouvelleAffectationAgentR, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AffectationAgentR> recupererToutesLesAffectationAgentRs() {
        return affectationAgentRService.recupererToutesLesAffectationAgentRs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationAgentR> recupererAffectationAgentRParId(@PathVariable int id) {
        Optional<AffectationAgentR> affectationAgentROptional = affectationAgentRService.recupererAffectationAgentRParId(id);
        if (affectationAgentROptional.isPresent()) {
            return new ResponseEntity<>(affectationAgentROptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationAgentR> modifierAffectationAgentR(@PathVariable int id, @RequestBody AffectationAgentR affectationAgentR) {
        Optional<AffectationAgentR> affectationAgentROptional = affectationAgentRService.recupererAffectationAgentRParId(id);
        if (affectationAgentROptional.isPresent()) {
            affectationAgentR.setId_AffectR(id);
            AffectationAgentR affectationAgentRModifie = affectationAgentRService.mettreAJourAffectationAgentR(affectationAgentR);
            return new ResponseEntity<>(affectationAgentRModifie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> supprimerAffectationAgentR(@PathVariable int id) {
        try {
            affectationAgentRService.supprimerAffectationAgentRParId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

