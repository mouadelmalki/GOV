package com.appsp.Oncf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.CompositionService;
import com.appsp.Oncf.models.Composition;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compositions")
public class CompositionController {

    @Autowired
    private CompositionService compositionService;

    @PostMapping
    public ResponseEntity<Composition> creerComposition(@RequestBody Composition composition) {
        Composition nouvelleComposition = compositionService.creerComposition(composition);
        return new ResponseEntity<>(nouvelleComposition, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Composition> recupererToutesLesCompositions() {
        return compositionService.recupererToutesLesCompositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composition> recupererCompositionParId(@PathVariable int id) {
        Optional<Composition> compositionOptional = compositionService.recupererCompositionParId(id);
        if (compositionOptional.isPresent()) {
            return new ResponseEntity<>(compositionOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Composition> mettreAJourComposition(@PathVariable int id, @RequestBody Composition composition) {
        Optional<Composition> compositionOptional = compositionService.recupererCompositionParId(id);
        if (compositionOptional.isPresent()) {
            composition.setId_AffectV(id);
            Composition compositionMiseAJour = compositionService.mettreAJourComposition(composition);
            return new ResponseEntity<>(compositionMiseAJour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerComposition(@PathVariable int id) {
        Optional<Composition> compositionOptional = compositionService.recupererCompositionParId(id);
        if (compositionOptional.isPresent()) {
            compositionService.supprimerComposition(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

