package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.models.Cours;
import com.iagi.artSchoolManagement.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;
    public List<Cours> getCourses(){
        return coursRepository.findAll();
    }
    public void save( Cours cours) {
        coursRepository.save(cours);
    }
    public Cours getCoursById(Integer idCours){
        Optional<Cours> e=coursRepository.findById(idCours);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }

}
