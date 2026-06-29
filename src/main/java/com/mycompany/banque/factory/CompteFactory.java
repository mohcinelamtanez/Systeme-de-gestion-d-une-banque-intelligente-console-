package com.mycompany.banque.factory;

import com.mycompany.banque.entity.Compte;
import com.mycompany.banque.entity.Client;
import com.mycompany.banque.entity.CompteCourant;

/**
 * @author USER
 **/
import java.time.LocalDate;
import java.util.ArrayList;

public class CompteFactory {

    public static Compte createStandardAccount() {
        return new CompteCourant(
                "CP001",
                5000.0,
                "Mohcine Lamtanez",
                LocalDate.now(),
                new ArrayList<>()
        );
    }

    public static Compte createRichAccount() {
        return new CompteCourant(
                "CP002",
                50000.0,
                "Aya Dahbi",
                LocalDate.now(),
                new ArrayList<>()
        );
    }

    public static Compte createEmptyAccount() {
        return new CompteCourant(
                "CP003",
                0.0,
                "Yassine Karim",
                LocalDate.now(),
                new ArrayList<>()
        );
    }
}