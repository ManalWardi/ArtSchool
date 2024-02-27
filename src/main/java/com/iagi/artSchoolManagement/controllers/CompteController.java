package com.iagi.artSchoolManagement.controllers;

import com.iagi.artSchoolManagement.models.Compte;
import com.iagi.artSchoolManagement.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping("/comptes")
    public String getComptes(Model model){

        List<Compte> compteList = compteService.getComptes();

        model.addAttribute("comptes", compteList);
        return "compte";
    }

    @PostMapping(value="comptes/addNew")
    public String addNew(Compte compte) {
        compteService.save(compte);
        return "redirect:/comptes";
    }

    @GetMapping("/modifCompte/{idCompte}")
    public String editCompte(@PathVariable Integer idCompte, Model m){
        Compte e=compteService.getCompteById(idCompte);
        m.addAttribute("compte",e);
        return "compteEdit";
    }

    @PostMapping(value="comptes/update")
    public String updateCompte(@ModelAttribute Compte e){
        compteService.save(e);
        return "redirect:/comptes";
    }
}
