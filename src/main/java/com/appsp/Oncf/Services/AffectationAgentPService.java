package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.AffectationAgentPRepository;
import com.appsp.Oncf.models.AffectationAgentP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationAgentPService {

    @Autowired
    private AffectationAgentPRepository affectationAgentPRepository;

    // Créer une affectation agent P

    public AffectationAgentP creerAffectationAgentP(AffectationAgentP affectationAgentP) {
        return affectationAgentPRepository.save(affectationAgentP);
    }

    // Récupérer toutes les affectations agents P

    public List<AffectationAgentP> recupererToutesLesAffectationsAgentsP() {
        return affectationAgentPRepository.findAll();
    }

    // Récupérer une affectation agent P par son ID

    public Optional<AffectationAgentP> recupererAffectationAgentPParId(int id) {
        return affectationAgentPRepository.findById(id);
    }

    // Mettre à jour une affectation agent P

    public AffectationAgentP mettreAJourAffectationAgentP(AffectationAgentP affectationAgentP) {
        return affectationAgentPRepository.save(affectationAgentP);
    }

    // Supprimer une affectation agent P

    public void supprimerAffectationAgentP(int id) {
        affectationAgentPRepository.deleteById(id);
    }

}

