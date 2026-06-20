/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banque.Model;
import com.mycompany.banque.*;
/**
 *
 * @author USER
 */
import java.time.*;
import java.util.*;

public class DataInitializer {

    public static List<Client> initClients() {

        // =========================
        // 1. Transactions
        // =========================

        Transaction t1 = new Transaction(
                1,
                200,
                LocalDateTime.now().minusDays(1),
                TypeOperation.depot,
                null,
                null,
                "Dépôt initial"
        );

        Transaction t2 = new Transaction(
                2,
                50,
                LocalDateTime.now(),
                TypeOperation.retrait,
                null,
                null,
                "Retrait ATM"
        );

        Transaction t3 = new Transaction(
                3,
                1000,
                LocalDateTime.now(),
                TypeOperation.virementSortant,
                null,
                null,
                "Virement salaire"
        );

        List<Transaction> histo1 = new ArrayList<>();
        histo1.add(t1);
        histo1.add(t2);

        List<Transaction> histo2 = new ArrayList<>();
        histo2.add(t3);

        List<Transaction> histo3 = new ArrayList<>();

        // =========================
        // 2. Comptes
        // =========================

        Compte compte1 = new CompteCourant(
                "CC-001",
                1200,
                "Ali",
                LocalDate.now().minusYears(2),
                histo1
        );

        Compte compte2 = new CompteEpargne(
                "CE-001",
                5000,
                "Ali",
                LocalDate.now().minusYears(1),
                histo3
        );

        Compte compte3 = new ComptePro(
                "CP-001",
                10000,
                "Sara",
                LocalDate.now().minusMonths(6),
                histo2
        );

        // =========================
        // 3. Clients
        // =========================

        Set<Compte> comptesClient1 = new HashSet<>();
        comptesClient1.add(compte1);
        comptesClient1.add(compte2);

        Client client1 = new Client(
                1,
                "Ali",
                "Benali",
                LocalDate.of(1998, 5, 12),
                "ali@email.com",
                LocalDate.now().minusYears(3),
                comptesClient1
        );

        Set<Compte> comptesClient2 = new HashSet<>();
        comptesClient2.add(compte3);

        Client client2 = new Client(
                2,
                "Sara",
                "El Amrani",
                LocalDate.of(1995, 10, 3),
                "sara@email.com",
                LocalDate.now().minusYears(2),
                comptesClient2
        );

        // =========================
        // 4. Retour liste clients
        // =========================

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}