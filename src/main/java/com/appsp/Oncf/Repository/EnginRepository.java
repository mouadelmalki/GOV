package com.appsp.Oncf.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.Engin;

import java.util.Optional;

@Repository
public interface EnginRepository extends JpaRepository<Engin, Integer> {
    Optional<Engin> findById(int id);

}
