package com.appsp.Oncf.Services;

import com.appsp.Oncf.Repository.EnginRepository;
import com.appsp.Oncf.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsp.Oncf.Repository.EnginRepository;
import com.appsp.Oncf.models.Engin;

import java.util.List;
import java.util.Optional;

@Service
public class EnginService {

    @Autowired
    private EnginRepository enginRepository;

    public Engin saveEngin(Engin engin) {
        return enginRepository.save(engin);
    }

    public List<Engin> getAllEngins() {
        return enginRepository.findAll();
    }

    public Optional<Engin> getEnginById(int id) {
        return enginRepository.findById(id);
    }

    public void deleteEnginById(int id) {
        enginRepository.deleteById(id);
    }


}


