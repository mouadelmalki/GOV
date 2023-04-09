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
@Table(name = "composition")
public class Composition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compo;

    @ManyToOne
    @JoinColumn(name = "id_affectv")
    private AffectationVoie affectationVoie;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

}
