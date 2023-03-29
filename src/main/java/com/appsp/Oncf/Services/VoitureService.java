package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.VoitureRepository;
import com.appsp.Oncf.models.Voiture;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public Voiture getVoitureById(int id) {
        return voitureRepository.findById(id).orElse(null);
    }

    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public void deleteVoiture(int id) {
        voitureRepository.deleteById(id);
    }
}

