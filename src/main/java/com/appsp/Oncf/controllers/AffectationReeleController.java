package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationReeleService;
import com.appsp.Oncf.models.AffectationReele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectationsReele")
public class AffectationReeleController {

    @Autowired
    private AffectationReeleService affectationReeleService;

    @PostMapping
    public ResponseEntity<AffectationReele> creerAffectationReele(@RequestBody AffectationReele affectationReele) {
        AffectationReele nouvelleAffectationReele = affectationReeleService.creerAffectationReele(affectationReele);
        return new ResponseEntity<>(nouvelleAffectationReele, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AffectationReele> recupererToutesLesAffectationReeles() {
        return affectationReeleService.recupererToutesLesAffectationReeles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationReele> recupererAffectationReeleParId(@PathVariable int id) {
        Optional<AffectationReele> affectationReeleOptional = affectationReeleService.recupererAffectationReeleParId(id);
        if (affectationReeleOptional.isPresent()) {
            return new ResponseEntity<>(affectationReeleOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationReele> modifierAffectationReele(@PathVariable int id, @RequestBody AffectationReele affectationReele) {
        Optional<AffectationReele> affectationReeleOptional = affectationReeleService.recupererAffectationReeleParId(id);
        if (affectationReeleOptional.isPresent()) {
            AffectationReele affectationReeleExistante = affectationReeleOptional.get();
            affectationReeleExistante.setAffectationVoie(affectationReele.getAffectationVoie());
            AffectationReele affectationReeleMiseAJour = affectationReeleService.mettreAJourAffectationReele(affectationReeleExistante);
            return new ResponseEntity<>(affectationReeleMiseAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAffectationReele(@PathVariable int id) {
        Optional<AffectationReele> affectationReeleOptional = affectationReeleService.recupererAffectationReeleParId(id);
        if (affectationReeleOptional.isPresent()) {
            affectationReeleService.supprimerAffectationReele(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

