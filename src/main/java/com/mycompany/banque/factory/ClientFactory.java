package com.mycompany.banque.factory;

import com.mycompany.banque.entity.Client;
import java.time.LocalDate;
import java.util.HashSet;


/**
 * @author USER
 **/


public class ClientFactory {

    public static Client createStandardClient() {
        return new Client(
                3,
                "Mohcine",
                "Lamtanez",
                LocalDate.of(2002, 5, 14),
                "mohcine@gmail.com",
                LocalDate.now(),
                new HashSet<>()
        );
    }

    public static Client createYoungClient() {
        return new Client(
                2,
                "Aya",
                "Dahbi",
                LocalDate.of(2005, 8, 20),
                "aya@gmail.com",
                LocalDate.now(),
                new HashSet<>()
        );
    }

    public static Client createOldClient() {
        return new Client(
                3,
                "Yassine",
                "Karim",
                LocalDate.of(1980, 3, 10),
                "yassine@gmail.com",
                LocalDate.now(),
                new HashSet<>()
        );
    }
}

