package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "affectationagentr")
public class AffectationAgentR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffectAR;

    @ManyToOne
    @JoinColumn(name = "id_affectr")
    private AffectationReele affectationReele;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur user;

}

