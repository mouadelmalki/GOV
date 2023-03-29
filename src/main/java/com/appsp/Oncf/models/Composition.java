package com.appsp.Oncf.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffectV;

    private int id_Voiture;

}
