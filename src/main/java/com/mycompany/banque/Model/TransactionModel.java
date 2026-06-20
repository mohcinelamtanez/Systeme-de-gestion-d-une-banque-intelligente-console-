/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.Model;
import java.time.*; 
import com.mycompany.banque.Compte; 
import com.mycompany.banque.TypeOperation;
/**
 *
 * @author USER
 */
public class TransactionModel {
        Transaction transaction = new Transaction(1 , 220 ,LocalDateTime.now(), TypeOperation.depot ,  )
}
  
        this.idTransaction = idTransaction ; 
        this.montant = montant ; 
        this.dateHeureTransaction = dateHeureTransaction ; 
        this.typeOperation = typeOperation ;
        this.compteSource = compteSource ; 
        this.compteDestination = compteDestination ; 
        this.description = description ;     