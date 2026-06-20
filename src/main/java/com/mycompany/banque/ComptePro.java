/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque;
import java.util.* ; 
import java.time.LocalDate ; 
/**
 *
 * @author USER
 */
public class ComptePro extends Compte{
   private static  int plafondTransactionQuotidien  = 10 ;
   
   public int getplafondTransactionQuotidien(){ 
      return ComptePro.plafondTransactionQuotidien ;
   }
   
   public boolean  peutEffectuerTransaction() { 
          return plafondTransactionQuotidien > calculerNombreTransactionparJour() ; 
   }
   
     public int calculerNombreTransactionparJour() { 
         LocalDate localdate = LocalDate.now() ;
         List<Transaction> filteredTransactions =   transactions.stream().
                                                    filter(transaction -> transaction.getdate().equals(localdate)).
                                                    toList() ; 

         return filteredTransactions.size() ; 
       }
   
   
}
