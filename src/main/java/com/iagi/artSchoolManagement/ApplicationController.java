package com.iagi.artSchoolManagement;

import java.security.Principal;

import com.iagi.artSchoolManagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.iagi.artSchoolManagement.models.Compte;
import com.iagi.artSchoolManagement.repositories.CompteRepository;
import com.iagi.artSchoolManagement.services.CompteService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationController {

    @Autowired
    private UserDetailsService userDetailsService;
    private CompteService compteService;

    public ApplicationController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/index")
    public String goHome(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail", userDetails);
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model, UserDto userDto) {
        model.addAttribute("compte", userDto);
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("compte", userDto);
        return "login";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("compte")UserDto userDto) {
        compteService.save(userDto);
        return "redirect:/register?success";
    }

}










