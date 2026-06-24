package com.mycompany.banque.repository.Interface;

import com.mycompany.banque.entity.Transaction;
import com.mycompany.banque.entity.TypeOperation;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends Repository<Transaction, Integer> {
    List<Transaction> findByCompteNumero(String numeroCompte);
    List<Transaction> findByType(TypeOperation type);
    List<Transaction> findByDateBetween(LocalDateTime debut, LocalDateTime fin);
    List<Transaction> findByMontantBetween(double min, double max);
    List<Transaction> findByDescriptionContaining(String keyword);
}