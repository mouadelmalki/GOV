package com.appsp.Oncf.secu;


import com.appsp.Oncf.Repository.UtilisateurRepository;
import com.appsp.Oncf.Services.UtilisateurService;
import com.appsp.Oncf.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/authent")
public class AuthController {

    @Autowired
    private  UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /*@PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurEnregistre = (Utilisateur) utilisateurService.loadUserByUsername(utilisateur.getLogin());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (utilisateurEnregistre != null && passwordEncoder.matches(utilisateur.getMotDePasse(), utilisateurEnregistre.getMotDePasse())) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }*/

   /* @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody Utilisateur utilisateur) {
        try {
            String message = utilisateurService.authenticateUser(utilisateur);
            return ResponseEntity.ok(message);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Utilisateur utilisateur) {
        // Recherchez l'utilisateur dans la base de données par login
        Utilisateur user = utilisateurRepository.findByLogin(utilisateur.getUsername());

        // Vérifiez si l'utilisateur existe dans la base de données et si le mot de passe est correct
        if (user != null && user.getPassword().equals(utilisateur.getPassword())) {

            // Si l'utilisateur existe et que le mot de passe est correct, retournez une réponse HTTP OK
            return ResponseEntity.ok("Connexion réussie!");

        } else {

            // Si l'utilisateur n'existe pas ou que le mot de passe est incorrect, retournez une réponse HTTP Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides!");
        }

    }

}


