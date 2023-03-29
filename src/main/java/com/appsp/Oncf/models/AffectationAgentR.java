package com.appsp.Oncf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Table(name = "affectation_agent_r")
public class AffectationAgentR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffectR;

    private int id_User;

}

