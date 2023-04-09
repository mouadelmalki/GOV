package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.VoieRepository;
import com.appsp.Oncf.models.Utilisateur;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.models.Voie;

import java.util.List;
import java.util.Optional;

@Service
public class VoieService {

    private final VoieRepository voieRepository;

    public VoieService(VoieRepository voieRepository) {
        this.voieRepository = voieRepository;
    }

    public List<Voie> recupererTousLesVoies() {
        return voieRepository.findAll();
    }

    public Voie getVoieById(int id) {
        Optional<Voie> voieOptional = voieRepository.findById(id);
        return voieOptional.orElse(null);
    }

    public Voie createVoie(Voie voie) {
        return voieRepository.save(voie);
    }

    public Voie updateVoie(int id, Voie voie) {
        Optional<Voie> voieOptional = voieRepository.findById(id);
        if (voieOptional.isPresent()) {
            voie.setId_voie(id);
            return voieRepository.save(voie);
        } else {
            return null;
        }
    }

    public boolean deleteVoie(int id) {
        Optional<Voie> voieOptional = voieRepository.findById(id);
        if (voieOptional.isPresent()) {
            voieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
