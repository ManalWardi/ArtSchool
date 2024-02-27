package com.iagi.artSchoolManagement;

import com.iagi.artSchoolManagement.models.Cours;
import com.iagi.artSchoolManagement.models.Formateur;
import com.iagi.artSchoolManagement.services.CoursService;
import com.iagi.artSchoolManagement.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WelcomeController {
    @Autowired
    private CoursService coursService;
    @Autowired
    private FormateurService formateurService;

    @GetMapping("/welcome")
    public String Welcome(Model model){
        List<Cours> coursList = coursService.getCourses();
        List<Formateur> formateurList = formateurService.getFormateurs();

        model.addAttribute("courses", coursList);
        model.addAttribute("formateurs", formateurList);
        return "welcome";
    }

    @GetMapping("/about")
    public String About(){
        return "about";
    }

    @GetMapping("/contact")
    public String Contact(){
        return "contact";
    }
}
