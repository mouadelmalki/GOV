package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationPrealableService;
import com.appsp.Oncf.models.AffectationPrealable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectationsPrealables")
public class AffectationPrealableController {
    @Autowired
    private AffectationPrealableService affectationPrealableService;

    @PostMapping
    public ResponseEntity<AffectationPrealable> creerAffectationPrealable(@RequestBody AffectationPrealable affectationPrealable) {
        AffectationPrealable nouvelleAffectationPrealable = affectationPrealableService.creerAffectationPrealable(affectationPrealable);
        return new ResponseEntity<>(nouvelleAffectationPrealable, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AffectationPrealable> recupererToutesLesAffectationPrealables() {
        return affectationPrealableService.recupererToutesLesAffectationPrealables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationPrealable> recupererAffectationPrealableParId(@PathVariable int id) {
        Optional<AffectationPrealable> affectationPrealableOptional = affectationPrealableService.recupererAffectationPrealableParId(id);
        if (affectationPrealableOptional.isPresent()) {
            return new ResponseEntity<>(affectationPrealableOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationPrealable> mettreAJourAffectationPrealable(@PathVariable int id, @RequestBody AffectationPrealable affectationPrealable) {
        affectationPrealable.setId_AffecP(id);
        AffectationPrealable affectationPrealableModifiee = affectationPrealableService.mettreAJourAffectationPrealable(affectationPrealable);
        if (affectationPrealableModifiee != null) {
            return new ResponseEntity<>(affectationPrealableModifiee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAffectationPrealable(@PathVariable int id) {
        affectationPrealableService.supprimerAffectationPrealable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
