package com.appsp.Oncf.Repository;


import com.appsp.Oncf.models.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Integer> {

    @Override
    Optional<Composition> findById(Integer integer);

    //<Composition> findById(int id);

    List<Composition> findAll();
}

