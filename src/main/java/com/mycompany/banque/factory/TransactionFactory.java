package com.mycompany.banque.factory;

import com.mycompany.banque.entity.Transaction ;
import com.mycompany.banque.entity.Compte;
import com.mycompany.banque.entity.TypeOperation;
import java.time.* ;
/**
 * @author USER
 **/


public class TransactionFactory {

    public static Transaction createDeposit(Compte compteDestination) {
        return new Transaction(
                1,
                1000.0,
                LocalDateTime.now(),
                TypeOperation.depot,
                null,
                compteDestination,
                "Dépôt initial"
        );
    }

    public static Transaction createWithdrawal(Compte compteSource) {
        return new Transaction(
                2,
                500.0,
                LocalDateTime.now(),
                TypeOperation.retrait,
                compteSource,
                null,
                "Retrait classique"
        );
    }

    public static Transaction createTransfer(Compte compteSource, Compte compteDestination) {
        return new Transaction(
                3,
                2000.0,
                LocalDateTime.now(),
                TypeOperation.virementSortant,
                compteSource,
                compteDestination,
                "Virement entre comptes"
        );
    }

    public static Transaction createBigWithdrawal(Compte compteSource) {
        return new Transaction(
                4,
                100000.0,
                LocalDateTime.now(),
                TypeOperation.retrait,
                compteSource,
                null,
                "Retrait superior au solde"
        );
    }
}