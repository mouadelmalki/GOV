package com.appsp.Oncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation,Integer> {
}
