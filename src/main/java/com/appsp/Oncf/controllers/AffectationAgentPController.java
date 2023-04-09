package com.appsp.Oncf.controllers;

import com.appsp.Oncf.Services.AffectationAgentPService;
import com.appsp.Oncf.models.AffectationAgentP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/affectation-agent-p")
public class AffectationAgentPController {

    @Autowired
    private AffectationAgentPService affectationAgentPService;

    @GetMapping("/{id}")
    public ResponseEntity<AffectationAgentP> getAffectationAgentPById(@PathVariable int id) {
        AffectationAgentP affectationAgentP = affectationAgentPService.getAffectationAgentPById(id);
        if (affectationAgentP != null) {
            return ResponseEntity.ok(affectationAgentP);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AffectationAgentP> createAffectationAgentP(@RequestBody AffectationAgentP affectationAgentP) {
        AffectationAgentP createdAffectationAgentP = affectationAgentPService.createAffectationAgentP(affectationAgentP);
        return ResponseEntity.created(URI.create("/affectation-agent-p/" + createdAffectationAgentP.getId_AffectAP())).body(createdAffectationAgentP);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationAgentP> updateAffectationAgentP(@PathVariable int id, @RequestBody AffectationAgentP affectationAgentP) {
        affectationAgentP.setId_AffectAP(id);
        AffectationAgentP updatedAffectationAgentP = affectationAgentPService.updateAffectationAgentP(affectationAgentP);
        if (updatedAffectationAgentP != null) {
            return ResponseEntity.ok(updatedAffectationAgentP);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectationAgentP(@PathVariable int id) {
        affectationAgentPService.deleteAffectationAgentPById(id);
        return ResponseEntity.noContent().build();
    }
}




