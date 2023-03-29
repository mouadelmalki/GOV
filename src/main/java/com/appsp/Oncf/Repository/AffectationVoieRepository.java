package com.appsp.Oncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.AffectationVoie;

@Repository
public interface AffectationVoieRepository extends JpaRepository<AffectationVoie, Integer> {
}

