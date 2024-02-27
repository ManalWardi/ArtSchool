package com.iagi.artSchoolManagement.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCompte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;
    private String username;
    private String password;
    private String role;
    @OneToOne(mappedBy = "compte")
    private Client client;

    public Compte(String username, String password, String role) {
        super();
        this.username=username;
        this.password=password;
        this.role=role;
    }
}
