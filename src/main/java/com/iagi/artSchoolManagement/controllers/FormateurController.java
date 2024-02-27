package com.iagi.artSchoolManagement.controllers;

import com.iagi.artSchoolManagement.models.Client;
import com.iagi.artSchoolManagement.models.Formateur;
import com.iagi.artSchoolManagement.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    @GetMapping("/formateurs")
    public String getFormateurs(Model model) {
        List<Formateur> formateurList = formateurService.getFormateurs();

        model.addAttribute("formateurs", formateurList);
        return "formateur";
    }

    @PostMapping(value="formateurs/addNew")
    public String addNew(Formateur formateur) {
        formateurService.save(formateur);
        return "redirect:/formateurs";
    }

    //welcome
    @GetMapping("/formateursPublic")
    public String getFormateursWelcome(Model model) {
        List<Formateur> formateurList = formateurService.getFormateurs();

        model.addAttribute("formateurs", formateurList);
        return "team";
    }

    @GetMapping("/modifFormateur/{idFormateur}")
    public String editFormateur(@PathVariable Integer idFormateur, Model m){
        Formateur e=formateurService.getFormateurById(idFormateur);
        m.addAttribute("formateur",e);
        return "formateurEdit";
    }

    @PostMapping(value="formateurs/update")
    public String updateFormateur(@ModelAttribute Formateur e){
        formateurService.save(e);
        return "redirect:/formateurs";
    }



}
