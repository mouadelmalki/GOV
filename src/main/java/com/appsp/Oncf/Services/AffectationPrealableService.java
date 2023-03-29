package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.AffectationPrealableRepository;
import com.appsp.Oncf.models.AffectationPrealable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationPrealableService {
    @Autowired
    private AffectationPrealableRepository affectationPrealableRepository;

    public AffectationPrealable creerAffectationPrealable(AffectationPrealable affectationPrealable) {
        return affectationPrealableRepository.save(affectationPrealable);
    }

    public List<AffectationPrealable> recupererToutesLesAffectationPrealables() {
        return affectationPrealableRepository.findAll();
    }

    public Optional<AffectationPrealable> recupererAffectationPrealableParId(int id) {
        return affectationPrealableRepository.findById(id);
    }

    public AffectationPrealable mettreAJourAffectationPrealable(AffectationPrealable affectationPrealable) {
        Optional<AffectationPrealable> affectationPrealableOptional = recupererAffectationPrealableParId(affectationPrealable.getId_AffecP());
        if (affectationPrealableOptional.isPresent()) {
            AffectationPrealable affectationPrealableAModifier = affectationPrealableOptional.get();
            affectationPrealableAModifier.setAffectVoie(affectationPrealable.getAffectVoie());
            return affectationPrealableRepository.save(affectationPrealableAModifier);
        } else {
            return null;
        }
    }

    public void supprimerAffectationPrealable(int id) {
        affectationPrealableRepository.deleteById(id);
    }

}
