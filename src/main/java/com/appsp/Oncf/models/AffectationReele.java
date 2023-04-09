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
@Table(name = "affectationreele")
public class AffectationReele implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffecR;

    @ManyToOne
    @JoinColumn(name = "affectvoie_id", referencedColumnName = "id_affecv")
    private AffectationVoie affectationVoie;

}

