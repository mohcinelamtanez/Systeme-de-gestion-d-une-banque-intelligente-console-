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
public class Client {
   private int Id ;
   private String nom ; 
   private String prenom ; 
   private LocalDate dateNaissance ; 
   private String adresseMail ; 
   private LocalDate dateCreation ; 
   private List<Compte> comptes; 
   
   public int getId() { 
       return this.Id ; 
   }
   
   public void setId(int Id) { 
       this.Id = Id ; 
   }
   
   public String getNom(){ 
       return this.nom ; 
   }
   
   public void setNom(String nom){ 
       this.nom = nom ; 
   }
   
   public String getPrenom(){ 
       return this.prenom ; 
   }
   
   public void setPrenom(String prenom){ 
       this.prenom = prenom ; 
   }
   
   public LocalDate getDateNaissance(){ 
       return this.dateNaissance; 
   }
   
   public void setDateNaissance(LocalDate dateNaissance){ 
       this.dateNaissance = dateNaissance ; 
   }
   
   public String getAdresseMail() { 
       return this.adresseMail ; 
   }
   
   public void setAdresseMail(String adresseMail){ 
       this.adresseMail = adresseMail ; 
   }
   
   public LocalDate getDateCreation(){
       return this.dateCreation; 
   }
   
   public void setDateCreation(LocalDate dateCreation ){
       this.dateCreation = dateCreation  ;
   }
   
   public List<Compte> getcomptesClient(){ 
       return this.comptes; 
   }
   
   public boolean setCompte(Compte c ){ 
       return this.comptes.add(c) ; 
   }
}
