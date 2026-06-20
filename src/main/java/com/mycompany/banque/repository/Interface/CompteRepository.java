package com.mycompany.banque.repository.Interface;

import com.mycompany.banque.*;

import java.util.List;
import java.util.Optional;

public interface CompteRepository extends Repository<Compte, String> {
    List<Compte> findByTitulaire(String titulaire);
    List<Compte> findByClientId(Integer clientId);
    List<CompteCourant> findAllComptesCourants();
    List<CompteEpargne> findAllComptesEpargne();
    List<ComptePro> findAllComptesPro();
    Optional<Compte> findByNumero(String numero);
    void addTransaction(String numeroCompte, Transaction transaction);   // ajouter une transaction à l'historique du compte
}