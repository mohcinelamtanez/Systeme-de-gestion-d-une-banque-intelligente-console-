/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.service;

import com.mycompany.banque.entity.Client;
import com.mycompany.banque.entity.Compte;
import com.mycompany.banque.Data.DataInitializer;
import com.mycompany.banque.exception.AccountAlreadyExistsException;
import com.mycompany.banque.exception.AccountNotFoundException;
import com.mycompany.banque.exception.ClientAlreadyExistsException;
import com.mycompany.banque.exception.ClientNotFoundException;
import com.mycompany.banque.repository.Implementation.InMemoryClientRepository;
import com.mycompany.banque.repository.Implementation.InMemoryCompteRepository;
import com.mycompany.banque.repository.Implementation.InMemoryTransactionRepository;

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

   // Ajouter un client

    public void ajouterClient(Client client) throws ClientAlreadyExistsException {
        if (clientRepo.existsById(client.getId())) {
                throw new ClientAlreadyExistsException("client existe déjà") ;
        }
            clientRepo.save(client);
    }

    // Supprimer un client

    public void supprimerClient(Client client) throws ClientNotFoundException{
        if (!(clientRepo.existsById(client.getId()))) {
            throw new ClientNotFoundException("Client introuvable !");
        }
             clientRepo.delete(client);
    }

// ouvrir un compte pour un client

    public void ouvrirCompte(Client client, Compte c) throws ClientNotFoundException , AccountNotFoundException {
        if (!(clientRepo.existsById(client.getId()))) {
            throw new ClientNotFoundException("client introuvable !") ;
        } if(client.getcomptesClient().stream().
                anyMatch(compte -> compte.getNumeroCompte().equalsIgnoreCase(c.getNumeroCompte()))){
          throw new AccountAlreadyExistsException("compte déjà existant  ! ");
        }
            compteRepo.save(c);
    }

//fermer un compte pour un client

    public void fermerCompte(Client client, Compte compte) throws AccountNotFoundException{
        if (!(client.getcomptesClient()
                .stream().
                anyMatch(c -> c.getNumeroCompte().
                        equalsIgnoreCase(compte.getNumeroCompte())))) {
            throw new AccountNotFoundException("compte introuvable !") ;
        }
        compteRepo.deleteById(compte.getNumeroCompte());

    }

    //rechercher un client

    public Client rechercherClient(Client client) throws ClientNotFoundException {
        Optional<Client> clientToFind = clientRepo.findById(client.getId());
        if(clientToFind.isEmpty()){
            throw new ClientNotFoundException("client recherché est introuvable !") ;
        }
         return clientToFind.get();
    }

    // rechercher un compte

    public Compte rechercherCompte(String numeroCompte) throws AccountNotFoundException{
         Optional<Compte> foundAccount = compteRepo.findById(numeroCompte);
         if(foundAccount.isEmpty()){
             throw new AccountNotFoundException("compte introuvable ! ") ;
    }
         return foundAccount.get();
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


    public void faireVirement(Compte src , Compte des , double montant ) {
        if(compteRepo.existsById(src.getNumeroCompte()) && compteRepo.existsById(des.getNumeroCompte())){
            src.retirer(montant);
            des.deposer(montant);
            System.out.println("Transaction effectué ! ") ;
        }else
             System.out.println("Something went wrong ! ") ;
    }
}