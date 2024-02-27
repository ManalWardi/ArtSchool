package com.iagi.artSchoolManagement.controllers;

import com.iagi.artSchoolManagement.models.Client;
import com.iagi.artSchoolManagement.models.Inscription;
import com.iagi.artSchoolManagement.services.ClientService;
import com.iagi.artSchoolManagement.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;
@Controller
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private ClientService clientService;

    //User
    @GetMapping("/Mesinscriptions")
    public String getInscriptionsUser(Model model) {
        // Récupérer toutes les inscriptions
        List<Inscription> inscriptionList = inscriptionService.getInscriptions();

        // Filtrer les inscriptions pour celles ayant idClient=1
        List<Inscription> filteredInscriptions = inscriptionList.stream()
                .filter(inscription -> inscription.getClient().getIdClient() == 2)
                .collect(Collectors.toList());

        // Passer les inscriptions filtrées au modèle
        model.addAttribute("Listinscriptions", filteredInscriptions);
        return "inscriptionUser";
    }

    //Admin
    @GetMapping("/inscriptions")
    public String getInscriptions(Model model) {
        List<Inscription> inscriptionList = inscriptionService.getInscriptions();

        model.addAttribute("Listinscriptions", inscriptionList);
        return "inscription";
    }



    @GetMapping("/modifInscription/{id}")
    public String editInscription(@PathVariable Integer id, Model m){
        Inscription e=inscriptionService.getInscriptionById(id);
        m.addAttribute("inscription",e);
        return "inscriptionEdit";
    }

    @PostMapping(value="inscriptions/update")
    public String updateInscription(@ModelAttribute Inscription e){
        inscriptionService.save(e);
        return "redirect:/inscriptions";
    }

    @PostMapping(value = "/inscrire")
    public String addNew(Inscription inscription) {
        // Définir l'état
        inscription.setEtat("en attente");

        // Récupérer le client existant avec idClient=1 depuis la base de données
        Client existingClient = clientService.getClientById(2); // Assurez-vous d'avoir une méthode similaire dans votre service

        // Vérifier si le client existe
        if (existingClient != null) {
            // Définir le client existant dans l'inscription
            inscription.setClient(existingClient);

            // Appeler le service pour sauvegarder l'inscription
            inscriptionService.save(inscription);


        }
        return "redirect:/tousCoursUser";
    }


}