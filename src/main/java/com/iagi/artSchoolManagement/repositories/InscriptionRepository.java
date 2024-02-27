package com.iagi.artSchoolManagement.repositories;


import com.iagi.artSchoolManagement.models.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {



}
