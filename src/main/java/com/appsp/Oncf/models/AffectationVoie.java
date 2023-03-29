package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.appsp.Oncf.models.Voiture;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AffectationVoie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Engin engin;

    private String motif;

    private String previsionSortie;

    @ManyToOne
    private Voie voie;

    private int emplacement;

    private boolean basseT;

    private boolean moyenneT;

    private boolean hauteT;

    private boolean miseATerre;

}

