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
@Table(name = "affectationprealable")
public class AffectationPrealable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_affecp;

    @ManyToOne
    @JoinColumn(name = "affectvoie_id", referencedColumnName = "id_affecv")
    private AffectationVoie affectationVoie;

}
