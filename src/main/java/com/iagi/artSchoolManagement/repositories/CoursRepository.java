package com.iagi.artSchoolManagement.repositories;


import com.iagi.artSchoolManagement.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
}
