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
     // logique pour ajouter un client 
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
    // logique pour supprimer un client 
    
    public void SupprimerClient(int id) {
        boolean exists = Banque.clients.stream().anyMatch(client -> client.getId() == id) ; 
        
        if(exists){ 
            Banque.clients.removeIf(client -> client.getId() == id) ; 
            System.out.println("client supprimé avec succès"); 
        }else {
            System.out.println("client introuvable ! ") ; 
        }
    }
    // logique pour rechercher un client par id 
    
    public Client rechercherClient(int id){
        List<Client> clientfiltered = Banque.clients.stream().filter(client -> client.getId() == id).toList() ; 
        
        if(!(clientfiltered.isEmpty())){  
            return clientfiltered.getFirst() ; 
        }else 
            System.out.println("client non trouvé ! "); 
            return null ;  
     }
    
    //logic pour ouvrir un compte 
    
    public void ouvrirCompte(Client client , Compte c , double solde ){ 
        c.setDateOuverture(LocalDate.now());
        c.setNumeroCompte("12333333"); 
        c.setProprietaire(client.getNom());
        c.setSolde(solde);
        
    }
    
    // logic pour chercher un compte par nombre 
    
      public Compte AccountByNumber(String numeroCompte) {
          
      List<Compte> foundedAccount = comptes.stream().
                                            filter(compte -> compte.getNumeroCompte().equals(numeroCompte)).
                                            toList() ; 

        return foundedAccount.getFirst(); 
  
} 
      
     public void effectuerTransaction(Transaction transaction) { 
         if(peutEffectuerTransaction()){
           transactions.add(transaction);
          System.out.println("transaction ajouté avec succès" ) ;    
            }else System.out.println("echec lors de l'jout de la transaction") ; 
          } 

     public boolean  peutEffectuerTransaction() { 
          return plafondTransactionQuotidien > calculerNombreTransactionparJour() ; } 
  
     public int calculerNombreTransactionparJour() { 
      List<Transaction> filteredTransactions =   transactions.stream().filter(transaction -> transaction.getdate() ==  Localedate.now()).toList() ; 

         return filteredTransactions.size() ; 
       }
  
     

        public void effectuerDepot(Client client , Compte compte , double montant) { 
           if(client.comptes.contains(compte)){
          c.deposer(montant); 
         } else {
         throw new AccountNotFoundException(
            "Le compte n'appartient pas à ce client"
        );
    } 
}

 
    public void retirerArgent(double montant) { this.solde -= montant ; } 
    
    public void effectuerRetrait(Client client , Compte c , double montant) { 
        if(client.comptes.contains(c)){ c.retirerArgent(montant) ; 
        }else if(montant < c.getsolde()) { 
            throw new InsufficientBalanceException( "Le compte n'appartient pas à ce client" );
        }else throw new AccountNotFoundException("compte introuvable") ; }
}
