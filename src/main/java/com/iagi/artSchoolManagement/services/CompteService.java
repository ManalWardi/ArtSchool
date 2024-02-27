package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.dto.UserDto;
import com.iagi.artSchoolManagement.models.Compte;
import com.iagi.artSchoolManagement.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private CompteRepository compteRepository;

    public void save( Compte compte) {
        compteRepository.save(compte);
    }
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }

    public CompteService(CompteRepository compteRepository){
        this.compteRepository = compteRepository;
    }

    public Compte findByUsername(String username){
        return compteRepository.findByUsername(username);
    }

    public Compte save(UserDto userDto){
        Compte compte = new Compte(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole());
        return compteRepository.save(compte);
    }

    public Compte getCompteById(Integer idCompte){
        Optional<Compte> e=compteRepository.findById(idCompte);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }

}
