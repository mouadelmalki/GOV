package com.appsp.Oncf.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.CompositionService;
import com.appsp.Oncf.models.Composition;

import java.util.List;

@RestController
@RequestMapping("/compositions")
public class CompositionController {

    private final CompositionService compositionService;

    public CompositionController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }

    @PostMapping
    public ResponseEntity<Composition> createComposition(@RequestBody Composition composition) {
        Composition createdComposition = compositionService.createComposition(composition);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComposition);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composition> getCompositionById(@PathVariable int id) {
        Composition composition = compositionService.getCompositionById(id);
        if (composition == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(composition);
    }

    @GetMapping
    public ResponseEntity<List<Composition>> getAllCompositions() {
        List<Composition> compositions = compositionService.getAllCompositions();
        return ResponseEntity.ok(compositions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Composition> updateComposition(@PathVariable int id, @RequestBody Composition composition) {
        Composition updatedComposition = compositionService.updateComposition(id, composition);
        if (updatedComposition == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedComposition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComposition(@PathVariable int id) {
        boolean deleted = compositionService.deleteComposition(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


