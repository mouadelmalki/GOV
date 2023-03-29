package com.appsp.Oncf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Table(name = "affectation_agent_p")
public class AffectationAgentP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AffectP;

    private int id_User;

}
