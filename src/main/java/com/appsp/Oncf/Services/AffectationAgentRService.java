package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.AffectationAgentRRepository;
import com.appsp.Oncf.models.AffectationAgentR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationAgentRService {

    @Autowired
    private AffectationAgentRRepository affectationAgentRRepository;

    public AffectationAgentR creerAffectationAgentR(AffectationAgentR affectationAgentR) {
        return affectationAgentRRepository.save(affectationAgentR);
    }

    public List<AffectationAgentR> recupererToutesLesAffectationAgentRs() {
        return affectationAgentRRepository.findAll();
    }

    public Optional<AffectationAgentR> recupererAffectationAgentRParId(int id) {
        return affectationAgentRRepository.findById(id);
    }

    public AffectationAgentR mettreAJourAffectationAgentR(AffectationAgentR affectationAgentR) {
        return affectationAgentRRepository.save(affectationAgentR);
    }

    public void supprimerAffectationAgentRParId(int id) {
        affectationAgentRRepository.deleteById(id);
    }
}

