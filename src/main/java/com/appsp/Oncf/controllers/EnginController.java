package com.appsp.Oncf.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.EnginService;
import com.appsp.Oncf.models.Engin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/engins")
@AllArgsConstructor
public class EnginController {
    @Autowired
    private EnginService enginService;

    @PostMapping
    public ResponseEntity<Engin> createEngin(@RequestBody Engin engin) {
        return new ResponseEntity<>(enginService.saveEngin(engin), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Engin>> getAllEngins() {
        return new ResponseEntity<>(enginService.getAllEngins(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Engin> getEnginById(@PathVariable int id) {
        Optional<Engin> enginOptional = enginService.getEnginById(id);
        return enginOptional.map(engin -> new ResponseEntity<>(engin, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnginById(@PathVariable int id) {
        enginService.deleteEnginById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
