package com.mycompany.banque.repository.Interface;

import com.mycompany.banque.entity.Client;
import com.mycompany.banque.entity.Compte;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends Repository<Client, Integer> {
    Optional<Client> findByEmail(String email);
    List<Client> findByNom(String nom);
    List<Client> findByPrenom(String prenom);
    Optional<Client> findClientByCompte(Compte compte);        // retrouver le client propriétaire d'un compte
    Optional<Client> findClientByCompteNumero(String numeroCompte);
}