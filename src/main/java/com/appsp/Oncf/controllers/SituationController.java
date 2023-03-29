package com.appsp.Oncf.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.SituationService;
import com.appsp.Oncf.models.Situation;

@RestController
@RequestMapping("/situations")
public class SituationController {

    private final SituationService situationService;

    public SituationController(SituationService situationService) {
        this.situationService = situationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Situation> getSituation(@PathVariable int id) {
        Situation situation = situationService.getSituationById(id);
        if(situation != null) {
            return ResponseEntity.ok(situation);
        }
        return ResponseEntity.notFound().build();
    }
}
