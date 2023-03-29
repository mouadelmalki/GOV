package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AffectationReele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffecR;

    private String affectVoie;

}

