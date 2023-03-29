package com.appsp.Oncf.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Affichage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "id_Situ")
    private Situation situation;
    private String message;
    @Temporal(TemporalType.DATE)
    private Date dateFr;
    private Date dateAr;
}
