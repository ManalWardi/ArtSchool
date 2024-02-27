package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.models.Compte;
import com.iagi.artSchoolManagement.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;


@Service
public class CustomUserDetailsServices implements UserDetailsService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    public CustomUserDetailsServices(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Compte compte = compteRepository.findByUsername(username);
        if(compte == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new CustomUserDetails(compte.getUsername(), compte.getPassword(), authorities(), compte.getRole());
    }

    public Collection<? extends GrantedAuthority> authorities(){
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
