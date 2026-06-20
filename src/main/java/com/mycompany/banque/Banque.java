/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banque;
import java.util.*;
import com.mycompany.banque.ClientRepository.ClientRepository;

/**
 *
 * @author USER
 */
public class Banque {
      
    
     
    
    public static void main(String[] args) {
       
        ClientRepository clientRepository = new ClientRepository() ; 
        System.out.println(clientRepository.findClientById(1)) ; 
          
          
         
    
    }
}
