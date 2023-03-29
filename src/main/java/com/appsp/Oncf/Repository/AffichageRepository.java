package com.appsp.Oncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.Affichage;

@Repository
public interface AffichageRepository extends JpaRepository<Affichage,Integer> {
}
