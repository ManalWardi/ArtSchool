package com.iagi.artSchoolManagement.models;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCours")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours;
    private String nom;


    private String date;
    private double prix;
    private String description;

    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;

    @ManyToOne
    @JoinColumn(name = "idFormateur")
    private Formateur formateur;

}
