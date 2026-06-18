/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque;
import java.time.*; 
import java.util.*;
/**
 *
 * @author USER
 */
public class ServiceBancaire {
      
    public void ajouterClient(String nom , String prenom , LocalDate dateNaissance , String adresseMail){ 
        Client newClient = new Client() ; 
        newClient.setNom(nom) ; 
        newClient.setPrenom(prenom) ; 
        newClient.setDateNaissance(dateNaissance) ; 
        newClient.setAdresseMail(adresseMail);
        
        if(newClient != null ){
            Banque.clients.add(newClient) ; 
            System.out.println("Client ajouté avec succès ! ") ; 
        }else System.out.println("ajout échoué !") ; 
    }
    
    public void SupprimerClient(int id) {
        boolean exists = Banque.clients.stream().anyMatch(client -> client.getId() == id) ; 
        
        if(exists){ 
            Banque.clients.removeIf(client -> client.getId() == id) ; 
            System.out.println("client supprimé avec succès"); 
        }else {
            System.out.println("client introuvable ! ") ; 
        }
    }
    
    public Client rechercherClient(int id){
        List<Client> clientfiltered = Banque.clients.stream().filter(client -> client.getId() == id).toList() ; 
        
        if(!(clientfiltered.isEmpty())){  
            return clientfiltered.getFirst() ; 
        }else 
            System.out.println("client non trouvé ! "); 
            return null ;  
     }
    
    public void ouvrirCompte(Client client , Compte c , double solde ){ 
        c.setDateOuverture(LocalDate.now());
        c.setNumeroCompte("12333333"); 
        c.setProprietaire(client.getNom());
        c.setSolde(solde);
        
    }
}
