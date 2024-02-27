package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.models.Client;
import com.iagi.artSchoolManagement.models.Formateur;
import com.iagi.artSchoolManagement.repositories.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepository formateurRepository;
    public List<Formateur> getFormateurs(){
        return formateurRepository.findAll();
    }


    public void save( Formateur formateur) {
        formateurRepository.save(formateur);
    }

    public Formateur getFormateurById(Integer idFormateur){
        Optional<Formateur> e=formateurRepository.findById(idFormateur);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }


}
