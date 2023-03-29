package com.appsp.Oncf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.appsp.Oncf.Services.UtilisateurService;
import com.appsp.Oncf.models.Utilisateur;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;


@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Créer un utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur nouvelUtilisateur = utilisateurService.creerUtilisateur(utilisateur);
        return new ResponseEntity<>(nouvelUtilisateur, HttpStatus.CREATED);
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return utilisateurService.recupererTousLesUtilisateurs();
    }

    // Récupérer un utilisateur par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> recupererUtilisateurParId(@PathVariable int id) {
        Optional<Utilisateur> utilisateurOpt = utilisateurService.recupererUtilisateurParId(id);
        if (utilisateurOpt.isPresent()) {
            return new ResponseEntity<>(utilisateurOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Modifier un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> modifierUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOpt = utilisateurService.recupererUtilisateurParId(id);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateurModifie = utilisateurService.mettreAJourUtilisateur(utilisateurOpt.get(), utilisateur);
            return new ResponseEntity<>(utilisateurModifie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> supprimerUtilisateur(@PathVariable int id) {
        Optional<Utilisateur> utilisateurOpt = utilisateurService.recupererUtilisateurParId(id);
        if (utilisateurOpt.isPresent()) {
            utilisateurService.supprimerUtilisateur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



