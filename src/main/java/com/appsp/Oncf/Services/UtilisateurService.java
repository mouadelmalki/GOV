package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.UtilisateurRepository;
import com.appsp.Oncf.models.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByLogin(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(utilisateur.getProfil()));
        return new User(utilisateur.getLogin(), utilisateur.getMotDePasse(), authorities);
    }


    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
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




