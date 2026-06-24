/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque;
import java.time.* ; 
import java.util.*;
/**
 *
 * @author USER
 */
public abstract class Compte {
 protected String numeroCompte ; 
 protected double solde ; 
 protected String proprietaire;
 protected LocalDate dateOuverture ; 
 protected List<Transaction> historiqueTransaction; 
 
  
 
 public String getNumeroCompte(){
     return this.numeroCompte ; 
 }
 
 public void setNumeroCompte(String numeroCompte){ 
     this.numeroCompte = numeroCompte ; 
 }
 
 public double getSolde(){ 
     return this.solde ;
 }
 
 public void setSolde(double solde){
    if(solde >= 0) {
        this.solde = solde ; 
    } else throw new IllegalArgumentException("Le solde doit être positif"); 
 }
 
 public LocalDate getDateOuverture(){
     return this.dateOuverture ; 
 }
 
 public void setDateOuverture(LocalDate dateOuverture) { 
     this.dateOuverture = dateOuverture ; 
 }
 
public String getProprietaire() {
    return this.proprietaire ; 
}

public void setProprietaire(String proprietaire) {
    this.proprietaire = proprietaire ; 
}

public List<Transaction> getTransactions(){ 
    return this.historiqueTransaction ; 
}

public void  setTransaction(List<Transaction> transactions){
    this.historiqueTransaction = transactions ;    
}

public List<Transaction> getHistoriqueTransaction(){
     return this.historiqueTransaction ;
}
public void deposer(double montant) { 
      if(montant > 0 )
          this.solde = solde + montant ;
     }

     public void retirer(double montant) {
     if(montant > 0 )
         this.solde  = solde - montant;
     }

public boolean ajouterTransaction(Transaction transaction) { 
   return this.historiqueTransaction.add(transaction) ; 
}

    @Override
    public String toString() {
        return "Compte{" +
                "numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", proprietaire='" + proprietaire + '\'' +
                ", dateOuverture=" + dateOuverture +
                ", historiqueTransaction=" + historiqueTransaction +
                '}';
    }
}
