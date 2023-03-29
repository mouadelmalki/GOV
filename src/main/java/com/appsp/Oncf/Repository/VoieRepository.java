package com.appsp.Oncf.Repository;

import com.appsp.Oncf.models.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoieRepository extends JpaRepository<Voie,Integer> {


}
