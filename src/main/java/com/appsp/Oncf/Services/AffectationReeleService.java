package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.AffectationReeleRepository;
import com.appsp.Oncf.models.AffectationReele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationReeleService {

    @Autowired
    private AffectationReeleRepository affectationReeleRepository;

    public AffectationReele creerAffectationReele(AffectationReele affectationReele) {
        return affectationReeleRepository.save(affectationReele);
    }

    public List<AffectationReele> recupererToutesLesAffectationReeles() {
        return affectationReeleRepository.findAll();
    }

    public Optional<AffectationReele> recupererAffectationReeleParId(int id) {
        return affectationReeleRepository.findById(id);
    }

    public AffectationReele mettreAJourAffectationReele(AffectationReele affectationReele) {
        Optional<AffectationReele> affectationReeleOptional = recupererAffectationReeleParId(affectationReele.getId_AffecR());
        if (affectationReeleOptional.isPresent()) {
            AffectationReele affectationReeleExistante = affectationReeleOptional.get();
            affectationReeleExistante.setAffectationVoie(affectationReele.getAffectationVoie());
            return affectationReeleRepository.save(affectationReeleExistante);
        } else {
            return null;
        }
    }

    public void supprimerAffectationReele(int id) {
        affectationReeleRepository.deleteById(id);
    }
}

