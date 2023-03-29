package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
//@Table(name = "VOIE")
public class Voie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "electrifiee")
    private Boolean electrifiee;

    @Column(name = "hors_service")
    private Boolean horsService;

    @Column(name = "sous_tension")
    private Boolean sousTension;

}

