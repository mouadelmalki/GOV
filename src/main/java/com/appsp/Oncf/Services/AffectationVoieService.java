package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.AffectationVoieRepository;
import com.appsp.Oncf.models.AffectationVoie;

import java.util.NoSuchElementException;

@Service
public class AffectationVoieService {

    @Autowired
    private AffectationVoieRepository affectationVoieRepository;

    public AffectationVoie getAffectationVoieById(int id) {
        return affectationVoieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Affectation de voie introuvable pour l'ID: " + id));
    }

    public AffectationVoie createAffectationVoie(AffectationVoie affectationVoie) {
        return affectationVoieRepository.save(affectationVoie);
    }

    public AffectationVoie updateAffectationVoie(int id, AffectationVoie affectationVoie) {
        AffectationVoie affectationVoieToUpdate = affectationVoieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Affectation de voie introuvable pour l'ID: " + id));
        affectationVoieToUpdate.setEngin_id(affectationVoie.getEngin_id());
        affectationVoieToUpdate.setMotif(affectationVoie.getMotif());
        affectationVoieToUpdate.setPrevisionsortie(affectationVoie.getPrevisionsortie());
        affectationVoieToUpdate.setVoie(affectationVoie.getVoie());
        affectationVoieToUpdate.setEmplacement(affectationVoie.getEmplacement());
        affectationVoieToUpdate.setBasset(affectationVoie.isBasset());
        affectationVoieToUpdate.setMoyennet(affectationVoie.isMoyennet());
        affectationVoieToUpdate.setHautet(affectationVoie.isHautet());
        affectationVoieToUpdate.setMiseaterre(affectationVoie.isMiseaterre());
        return affectationVoieRepository.save(affectationVoieToUpdate);
    }

    public void deleteAffectationVoie(int id) {
        AffectationVoie affectationVoieToDelete = affectationVoieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Affectation de voie introuvable pour l'ID: " + id));
        affectationVoieRepository.delete(affectationVoieToDelete);
    }
}

