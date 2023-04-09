package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "affectationvoie")
public class AffectationVoie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_affecv;

    @ManyToOne
    private Engin engin_id;

    private String motif;

    private String previsionsortie;

    @ManyToOne
    private Voie voie;

    private int emplacement;

    private boolean basset;

    private boolean estimmobilise;

    private boolean moyennet;

    private boolean hautet;

    private boolean miseaterre;

}

