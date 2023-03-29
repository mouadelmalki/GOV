package com.appsp.Oncf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.CompositionRepository;
import com.appsp.Oncf.models.Composition;

import java.util.List;
import java.util.Optional;

@Service
public class CompositionService {

    @Autowired
    private CompositionRepository compositionRepository;

    public Composition creerComposition(Composition composition) {
        return compositionRepository.save(composition);
    }

    public List<Composition> recupererToutesLesCompositions() {
        return compositionRepository.findAll();
    }

    public Optional<Composition> recupererCompositionParId(int id) {
        return compositionRepository.findById(id);
    }

    public Composition mettreAJourComposition(Composition composition) {
        return compositionRepository.save(composition);
    }

    public void supprimerComposition(int id) {
        compositionRepository.deleteById(id);
    }
}

