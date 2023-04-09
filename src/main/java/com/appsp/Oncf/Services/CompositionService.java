package com.appsp.Oncf.Services;

import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.CompositionRepository;
import com.appsp.Oncf.models.Composition;

import java.util.List;
@Service
public class CompositionService {

    private final CompositionRepository compositionRepository;

    public CompositionService(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }

    public Composition createComposition(Composition composition) {
        return compositionRepository.save(composition);
    }

    public Composition getCompositionById(int id) {
        return compositionRepository.findById(id).orElse(null);
    }

    public List<Composition> getAllCompositions() {
        return compositionRepository.findAll();
    }

    public Composition updateComposition(int id, Composition composition) {
        Composition existingComposition = compositionRepository.findById(id).orElse(null);
        if (existingComposition == null) {
            return null;
        }
        composition.setCompo(existingComposition.getCompo());
        return compositionRepository.save(composition);
    }

    public boolean deleteComposition(int id) {
        Composition existingComposition = compositionRepository.findById(id).orElse(null);
        if (existingComposition == null) {
            return false;
        }
        compositionRepository.delete(existingComposition);
        return true;
    }
}


