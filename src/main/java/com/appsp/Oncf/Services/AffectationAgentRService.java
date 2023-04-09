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

    public AffectationAgentR getAffectationAgentRById(int id) {
        Optional<AffectationAgentR> optionalAffectationAgentR = affectationAgentRRepository.findById(id);
        return optionalAffectationAgentR.orElse(null);
    }

    public AffectationAgentR createAffectationAgentR(AffectationAgentR affectationAgentR) {
        return affectationAgentRRepository.save(affectationAgentR);
    }

    public AffectationAgentR updateAffectationAgentR(AffectationAgentR affectationAgentR) {
        Optional<AffectationAgentR> optionalAffectationAgentR = affectationAgentRRepository.findById(affectationAgentR.getId_AffectAR());
        if (optionalAffectationAgentR.isPresent()) {
            return affectationAgentRRepository.save(affectationAgentR);
        } else {
            return null;
        }
    }

    public void deleteAffectationAgentRById(int id) {
        affectationAgentRRepository.deleteById(id);
    }
}


