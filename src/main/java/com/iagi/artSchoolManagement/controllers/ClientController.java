package com.iagi.artSchoolManagement.controllers;

import com.iagi.artSchoolManagement.models.Client;
import com.iagi.artSchoolManagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getClients(Model model){

        List<Client> clientList = clientService.getClients();

        model.addAttribute("clients", clientList);
        return "client";
    }

    @PostMapping(value="clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/modifClient/{idClient}")
    public String editClient(@PathVariable Integer idClient,Model m){
        Client e=clientService.getClientById(idClient);
        m.addAttribute("client",e);
        return "clientEdit";
    }

    @PostMapping(value="clients/update")
    public String updateClient(@ModelAttribute Client e){
        clientService.save(e);
        return "redirect:/clients";
    }



}
