package com.iagi.artSchoolManagement.repositories;

import com.iagi.artSchoolManagement.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findByUsername(String username);

}
