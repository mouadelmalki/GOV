package com.appsp.Oncf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appsp.Oncf.models.Utilisateur;

import java.util.Optional;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    //Utilisateur findByLogin(String login);

    //Optional<Utilisateur> findById_User(int id);;
}

