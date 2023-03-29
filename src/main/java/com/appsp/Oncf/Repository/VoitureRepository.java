package com.appsp.Oncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {

}
