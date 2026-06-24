/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.service;

import com.mycompany.banque.Client;
import com.mycompany.banque.Compte;
import com.mycompany.banque.Data.DataInitializer;
import com.mycompany.banque.repository.Implementation.InMemoryClientRepository;
import com.mycompany.banque.repository.Implementation.InMemoryCompteRepository;
import com.mycompany.banque.repository.Implementation.InMemoryTransactionRepository;
import com.mycompany.banque.repository.Interface.ClientRepository;
import com.mycompany.banque.repository.Interface.Repository;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

/**
 *
 * @author USER
 */
public class ServiceBancaire {


    List<Client> clients = DataInitializer.initClients();
    InMemoryClientRepository clientRepo = new InMemoryClientRepository(clients);
    InMemoryCompteRepository compteRepo = new InMemoryCompteRepository(clients, clientRepo);
    InMemoryTransactionRepository transactionRepo = new InMemoryTransactionRepository(clients);


    public void ajouterClient(Client client) {
        if (clientRepo.existsById(client.getId())) {
            System.out.println("client existe déjà");
        } else
            clientRepo.save(client);
    }

    public void supprimerClient(Client client) {
        if (clientRepo.existsById(client.getId())) {
            clientRepo.delete(client);
        } else System.out.println("client introuvable :! ");
    }

    public void ouvrirCompte(Client client, Compte c) {
        if (clientRepo.existsById(client.getId())) {
            compteRepo.save(c);
        } else
            System.out.println("client n'existe pas !");
    }

    public void fermerCompte(Client client, Compte compte) {
        if (client.getcomptesClient()
                .stream().
                anyMatch(c -> c.getNumeroCompte().
                        equalsIgnoreCase(compte.getNumeroCompte()))) {
            compteRepo.deleteById(compte.getNumeroCompte());
        } else {
            System.out.println("client ne possède pas le compte indiqué !");
        }

    }

    public Client rechercherClient(Client c) {
        return clientRepo.findById(c.getId()).get();
    }


    public Compte rechercherCompte(Client client, Compte compte) {
        return clientRepo.findById(client.getId()).get().getcomptesClient().stream().
                filter(c -> c.getNumeroCompte().equalsIgnoreCase(compte.getNumeroCompte())).toList().getFirst();

    }

    public void faireDepot(Client client, Compte compte, double montant) {
        if (clientRepo.findById(client.getId()).isPresent()) {
            Compte comptePourDebiter = clientRepo.findById(client.getId()).get().getcomptesClient().stream().
                    filter(c -> c.getNumeroCompte().equalsIgnoreCase(compte.getNumeroCompte())).toList().getFirst();

            comptePourDebiter.deposer(montant);
        }

    }

    public void faireRetrait(Compte compte, double montant) {
        if (compteRepo.existsById(compte.getNumeroCompte()) &&
                compteRepo.findById(compte.getNumeroCompte()).get().getSolde() > montant
        ) {
            compteRepo.findById(compte.getNumeroCompte()).get().retirer(montant);
        }
    }
}