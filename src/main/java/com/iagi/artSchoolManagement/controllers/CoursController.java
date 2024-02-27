package com.iagi.artSchoolManagement.controllers;

import com.iagi.artSchoolManagement.models.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.iagi.artSchoolManagement.services.CoursService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CoursController {
    @Autowired
    private CoursService coursService;

    //User
    @GetMapping("/tousCoursUser")
    public String getCoursesUser(Model model) {
        List<Cours> coursList = coursService.getCourses();

        model.addAttribute("courses", coursList);

        return "coursUser";
    }

    //Admin
    @GetMapping("/courses")
    public String getCourses(Model model){

        List<Cours> coursList = coursService.getCourses();

        model.addAttribute("courses", coursList);
        return "cours";
    }

    @PostMapping(value="courses/addNew")
    public String addNew(Cours cours) {
        coursService.save(cours);
        return "redirect:/courses";
    }

    //welcome
    @GetMapping("/coursesPublic")
    public String getCoursesWelcome(Model model) {
        List<Cours> coursList = coursService.getCourses();

        model.addAttribute("courses", coursList);
        return "course";
    }

    @GetMapping("/modifCours/{idCours}")
    public String editCours(@PathVariable Integer idCours, Model m){
        Cours e=coursService.getCoursById(idCours);
        m.addAttribute("cours",e);
        return "coursEdit";
    }

    @PostMapping(value="courses/update")
    public String updateCompte(@ModelAttribute Cours e){
        coursService.save(e);
        return "redirect:/courses";
    }
}
