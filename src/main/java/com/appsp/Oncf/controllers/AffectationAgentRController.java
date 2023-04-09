package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationAgentRService;
import com.appsp.Oncf.models.AffectationAgentR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/affectationsAgentR")
public class AffectationAgentRController {

    @Autowired
    private AffectationAgentRService affectationAgentRService;

    @GetMapping("/{id}")
    public ResponseEntity<AffectationAgentR> getAffectationAgentRById(@PathVariable int id) {
        AffectationAgentR affectationAgentR = affectationAgentRService.getAffectationAgentRById(id);
        if (affectationAgentR != null) {
            return ResponseEntity.ok(affectationAgentR);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AffectationAgentR> createAffectationAgentR(@RequestBody AffectationAgentR affectationAgentR) {
        affectationAgentR = affectationAgentRService.createAffectationAgentR(affectationAgentR);
        return ResponseEntity.status(HttpStatus.CREATED).body(affectationAgentR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationAgentR> updateAffectationAgentR(@PathVariable int id, @RequestBody AffectationAgentR affectationAgentR) {
        affectationAgentR.setId_AffectAR(id);
        affectationAgentR = affectationAgentRService.updateAffectationAgentR(affectationAgentR);
        if (affectationAgentR != null) {
            return ResponseEntity.ok(affectationAgentR);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectationAgentRById(@PathVariable int id) {
        affectationAgentRService.deleteAffectationAgentRById(id);
        return ResponseEntity.noContent().build();
    }
}

