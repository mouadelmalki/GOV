package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.UtilisateurRepository;
import com.appsp.Oncf.models.Utilisateur;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

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



