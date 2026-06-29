/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banque.ui;

import com.mycompany.banque.service.ServiceBancaire;
import com.mycompany.banque.entity.Client;
import com.mycompany.banque.entity.Compte ;
import com.mycompany.banque.factory.* ;

/**
 *
 * @author USER
 */
public class Banque {
    
    public static void main(String[] args) {

  // tester les methodes provisoirement

        ServiceBancaire serviceBancaire  = new ServiceBancaire();

        Client client = ClientFactory.createStandardClient();
        serviceBancaire.ajouterClient(client);


    }
}
