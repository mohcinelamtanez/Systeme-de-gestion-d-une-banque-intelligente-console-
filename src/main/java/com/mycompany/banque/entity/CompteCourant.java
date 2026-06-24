/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.entity;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author USER
 */
public class CompteCourant extends Compte {
    
    private final double fraisMensuel = 20 ;  
    private final double limiteDecouvert = 40; 
    
    public CompteCourant
        (String numeroCompte , double solde , String proprietaire , LocalDate dateOuverture , List<Transaction> historiqueTransaction){
     super.numeroCompte = numeroCompte ; 
     super.solde = solde ; 
     super.proprietaire = proprietaire ; 
     super.dateOuverture = dateOuverture ; 
     super.historiqueTransaction = historiqueTransaction ; 
 }
}
