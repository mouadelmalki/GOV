package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.AffichageRepository;
import com.appsp.Oncf.models.Affichage;

@Service
public class AffichageService {

    @Autowired
    private AffichageRepository affichageRepository;

    public Affichage getAffichage(int id) {
        return affichageRepository.findById(id).orElse(null);
    }

    public Affichage createAffichage(Affichage affichage) {
        return affichageRepository.save(affichage);
    }

    public Affichage updateAffichage(Affichage affichage) {
        return affichageRepository.save(affichage);
    }

    public void deleteAffichage(int id) {
        affichageRepository.deleteById(id);
    }
}

