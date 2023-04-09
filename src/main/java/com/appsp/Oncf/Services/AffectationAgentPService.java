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

    public AffectationAgentP getAffectationAgentPById(int id) {
        Optional<AffectationAgentP> optionalAffectationAgentP = affectationAgentPRepository.findById(id);
        return optionalAffectationAgentP.orElse(null);
    }

    public AffectationAgentP createAffectationAgentP(AffectationAgentP affectationAgentP) {
        return affectationAgentPRepository.save(affectationAgentP);
    }

    public AffectationAgentP updateAffectationAgentP(AffectationAgentP affectationAgentP) {
        Optional<AffectationAgentP> optionalAffectationAgentP = affectationAgentPRepository.findById(affectationAgentP.getId_AffectAP());
        if (optionalAffectationAgentP.isPresent()) {
            return affectationAgentPRepository.save(affectationAgentP);
        } else {
            return null;
        }
    }

    public void deleteAffectationAgentPById(int id) {
        affectationAgentPRepository.deleteById(id);
    }
}

