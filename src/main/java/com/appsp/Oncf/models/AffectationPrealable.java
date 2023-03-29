package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AffectationPrealable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffecP;

    private String affectVoie;

}
