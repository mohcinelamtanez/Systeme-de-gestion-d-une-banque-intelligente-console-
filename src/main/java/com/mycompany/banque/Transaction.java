/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque;
import java.time.* ; 
/**
 *
 * @author USER
 */
public class Transaction {
    private int idTransaction ; 
    private double montant ;
    private LocalDateTime timeTransaction ;
    private TypeOperation typeOperation ; 
    private Compte compteSource ; 
    private Compte compteDestination ; 
    private String description ;


    public Transaction(int idTransaction , double montant , LocalDateTime dateHeureTransaction , TypeOperation typeOperation , Compte compteSource , Compte compteDestination  , String description){
        this.idTransaction = idTransaction ; 
        this.montant = montant ; 
        this.timeTransaction = dateHeureTransaction ;
        this.typeOperation = typeOperation ;
        this.compteSource = compteSource ; 
        this.compteDestination = compteDestination ; 
        this.description = description ;        
        
    }
    public int getIdTransaction(){ 
        return this.idTransaction;  
    }
    
    public void setIdTransaction(int idTransaction ){
        this.idTransaction = idTransaction  ; 
    }
    
    public double getMontant() { 
        return this.montant;         
    }
    
    public void setMontant(double montant){
        this.montant = montant ; 
    }
    
    public LocalDateTime getTimeTransaction(){
        return this.timeTransaction ;
    }
    
    public void setTimeTransaction(LocalDateTime timeTransaction ) {
        this.timeTransaction = timeTransaction ;
    }
    
    public String getDescription(){ 
        return this.description ; 
    }
    
    public void setDescription(String description){ 
        this.description = description ; 
    }

    public TypeOperation getTypeOperation(){
        return this.typeOperation;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", montant=" + montant +
                ", dateHeureTransaction=" + timeTransaction +
                ", typeOperation=" + typeOperation +
                ", compteSource=" + compteSource +
                ", compteDestination=" + compteDestination +
                ", description='" + description + '\'' +
                '}';
    }
}
