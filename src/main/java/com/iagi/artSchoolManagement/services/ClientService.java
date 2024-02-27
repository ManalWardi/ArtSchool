package com.iagi.artSchoolManagement.services;

import com.iagi.artSchoolManagement.models.Client;
import com.iagi.artSchoolManagement.models.Compte;
import com.iagi.artSchoolManagement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void save( Client client) {
        clientRepository.save(client);
    }

    public Client getClientById(Integer idClient){
        Optional<Client> e=clientRepository.findById(idClient);
        if (e.isPresent()){
            return e.get();
        }
        return null;
    }


    public void deleteClient(Integer idClient) {
        // Supprimer le client par son ID
        clientRepository.deleteById(idClient);
    }

//    @Transactional
//    public void trouverClient(Integer id){System.out.println("Compte associé : " + clientRepository.findById(id)); }
//
//    public Compte trouverCompte(Client client){return client.getCompte();}



}
