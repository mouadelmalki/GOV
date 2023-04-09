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
@Table(name = "affectationagentp")
public class AffectationAgentP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffectAP;

    @ManyToOne
    @JoinColumn(name = "id_affecp")
    private AffectationPrealable affectationP;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur user;

}
