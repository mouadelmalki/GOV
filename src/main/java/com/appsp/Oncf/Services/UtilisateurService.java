package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.UtilisateurRepository;
import com.appsp.Oncf.models.Utilisateur;

import java.util.*;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

  /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByLogin(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(utilisateur.getProfil()));
        return new User(utilisateur.getLogin(), utilisateur.getMotDePasse(), authorities);
    }*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Recherchez l'utilisateur dans la base de données par login
        Utilisateur utilisateur = utilisateurRepository.findByLogin(username);

        // Si l'utilisateur n'existe pas, lancez une exception UsernameNotFoundException
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Nom d'utilisateur introuvable!");
        }

        // Retournez les informations d'identification de l'utilisateur (nom d'utilisateur, mot de passe et rôle)
        return new User(utilisateur.getUsername(), utilisateur.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(utilisateur.getProfil())));
    }


   /* public String login(Utilisateur utilisateur) throws UsernameNotFoundException {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Utilisateur dbUtilisateur = utilisateurRepository.findByLogin(utilisateur.getLogin());
        System.out.println("Utilisateur de la base de données : " + dbUtilisateur);
        if (dbUtilisateur != null && bCrypt.matches(utilisateur.getPassword(), dbUtilisateur.getPassword())) {
            System.out.println("Mot de passe correct pour l'utilisateur " + dbUtilisateur.getLogin());
            return "authenticated User";
        } else {
            System.out.println("Mauvais mot de passe pour l'utilisateur " + utilisateur.getLogin());
            throw new UsernameNotFoundException("Utilisateur non trouvé ou mot de passe incorrect.");
        }
    }*/


    /*public String authenticateUser(Utilisateur utilisateur) throws UsernameNotFoundException {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Utilisateur dbUtilisateur = utilisateurRepository.findByLogin(utilisateur.getLogin());
        if (dbUtilisateur != null && bCrypt.matches(utilisateur.getPassword(), dbUtilisateur.getPassword())) {
            return "authenticated User";
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé ou mot de passe incorrect.");
        }
    }*/




    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String motDePasseCrypte = bCrypt.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseCrypte);
        return utilisateurRepository.save(utilisateur);
    }




    public List<Utilisateur> recupererTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> recupererUtilisateurParId(int id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur mettreAJourUtilisateur(Utilisateur id, Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(id.getId_User());
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateurExistant = utilisateurOpt.get();
            utilisateurExistant.setLogin(utilisateur.getLogin());
            utilisateurExistant.setMotDePasse(utilisateur.getMotDePasse());
            utilisateurExistant.setProfil(utilisateur.getProfil());
            return utilisateurRepository.save(utilisateurExistant);
        } else {
            return null;
        }
    }

    public void supprimerUtilisateur(int id) {
        utilisateurRepository.deleteById(id);
    }

}




