package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Table(name = "voie")
public class Voie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_voie;

    private Boolean electrifiee;

    private Boolean horservice;

    private Boolean soustension;

}

