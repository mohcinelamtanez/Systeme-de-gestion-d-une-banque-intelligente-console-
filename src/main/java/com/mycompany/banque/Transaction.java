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
    private LocalDateTime dateHeureTransaction ; 
    private TypeOperation typeOperation ; 
    private Compte compteSource ; 
    private Compte compteDestination ; 
    private String description ;

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", montant=" + montant +
                ", dateHeureTransaction=" + dateHeureTransaction +
                ", typeOperation=" + typeOperation +
                ", compteSource=" + compteSource +
                ", compteDestination=" + compteDestination +
                ", description='" + description + '\'' +
                '}';
    }

    public Transaction(int idTransaction , double montant , LocalDateTime dateHeureTransaction , TypeOperation typeOperation , Compte compteSource , Compte compteDestination  , String description){
        this.idTransaction = idTransaction ; 
        this.montant = montant ; 
        this.dateHeureTransaction = dateHeureTransaction ; 
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
    
    public LocalDateTime getDateHeureTransaction(){ 
        return this.dateHeureTransaction ; 
    }
    
    public void setDateHeureTransaction(LocalDateTime dateHeureTransaction ) {
        this.dateHeureTransaction = dateHeureTransaction ; 
    }
    
    public String getDescription(){ 
        return this.description ; 
    }
    
    public void setDescription(String description){ 
        this.description = description ; 
    }
}
