package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.models.Cours;
import com.iagi.artSchoolManagement.models.Inscription;
import com.iagi.artSchoolManagement.repositories.CoursRepository;
import com.iagi.artSchoolManagement.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;
    public List<Inscription> getInscriptions(){
        return inscriptionRepository.findAll();
    }

    public void save(Inscription inscription) {
        inscriptionRepository.save(inscription);
    }

    public Inscription getInscriptionById(Integer id){
        Optional<Inscription> e=inscriptionRepository.findById(id);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }

}
