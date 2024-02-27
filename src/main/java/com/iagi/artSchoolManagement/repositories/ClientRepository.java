package com.iagi.artSchoolManagement.repositories;

import com.iagi.artSchoolManagement.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
