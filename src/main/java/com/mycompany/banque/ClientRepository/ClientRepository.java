/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.ClientRepository;
import com.mycompany.banque.Data.*;
import com.mycompany.banque.*;

/**
 *
 * @author USER
 */
public class ClientRepository {
    public Client findClientById(int id) { 
        Client foundedClient = DataInitializer.initClients().stream().
                                      filter(client -> client.getId() == id).
                                      toList().getFirst();
        return foundedClient ;
    }
}
