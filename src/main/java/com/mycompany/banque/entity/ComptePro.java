/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.entity;

import java.util.* ;
import java.time.LocalDate ; 
/**
 *
 * @author USER
 */
public class ComptePro extends Compte {
   private static  int plafondTransactionQuotidien  = 10 ;
   
  
    public ComptePro
        (String numeroCompte , double solde , String proprietaire , LocalDate dateOuverture , List<Transaction> historiqueTransaction){
     super.numeroCompte = numeroCompte ; 
     super.solde = solde ; 
     super.proprietaire = proprietaire ; 
     super.dateOuverture = dateOuverture ; 
     super.historiqueTransaction = historiqueTransaction ; 
 }

   
}
