/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banque;
import java.util.*;

/**
 *
 * @author USER
 */
public class Banque {
       
    public static List<Client> clients = new ArrayList<>(); 
    public static Client clientA = new Client(); 
    
     
    
    public static void main(String[] args) {
          Compte A = new CompteCourant(); 
          Compte B = new CompteEpargne(); 
          Compte C = new ComptePro(); 
          Set<Compte> comptes = new HashSet<>(List.of(A , B , C));
          List<Transaction> transactions = new ArrayList<>() ; 
          clientA.setComptesClient(comptes); 
          
         
    
    }
}
