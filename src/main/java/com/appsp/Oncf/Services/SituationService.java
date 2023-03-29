package com.appsp.Oncf.Services;

import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.SituationRepository;
import com.appsp.Oncf.models.Situation;

import java.util.Optional;

@Service
public class SituationService {

    private final SituationRepository situationRepository;

    public SituationService(SituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    public Situation getSituationById(int id) {
        Optional<Situation> optionalSituation = situationRepository.findById(id);
        return optionalSituation.orElse(null);
    }


}






