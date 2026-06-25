package com.mycompany.banque.repository.Implementation;

import com.mycompany.banque.entity.*;
import com.mycompany.banque.repository.Interface.CompteRepository;
import com.mycompany.banque.repository.Interface.ClientRepository;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCompteRepository implements CompteRepository {

    private final Map<String, Compte> comptes = new HashMap<>();
    private final ClientRepository clientRepository; // pour mise à jour éventuelle

    public InMemoryCompteRepository(List<Client> clients, ClientRepository clientRepo) {
        this.clientRepository = clientRepo;
        // Initialiser à partir des comptes des clients
        for (Client c : clients) {
            for (Compte compte : c.getcomptesClient()) {
                comptes.put(compte.getNumeroCompte(), compte);
            }
        }
    }

    @Override
    public Compte save(Compte entity) {
        // Si le compte existe déjà, on le remplace
        comptes.put(entity.getNumeroCompte(), entity);
        // Mettre à jour le client associé (si nécessaire)
        // On suppose que le client est déjà dans la map
        return entity;
    }

    @Override
    public Optional<Compte> findById(String numero) {
        return Optional.ofNullable(comptes.get(numero));
    }

    @Override
    public List<Compte> findAll() {
        return new ArrayList<>(comptes.values());
    }

    @Override
    public void deleteById(String numero) {
        comptes.remove(numero);
    }

    @Override
    public void delete(Compte entity) {
        comptes.remove(entity.getNumeroCompte());
    }

    @Override
    public boolean existsById(String numero) {
        return comptes.containsKey(numero);
    }

    @Override
    public long count() {
        return comptes.size();
    }

    @Override
    public List<Compte> findByTitulaire(String titulaire) {
        return comptes.values().stream()
                .filter(c -> c.getProprietaire().equalsIgnoreCase(titulaire))
                .collect(Collectors.toList());
    }

    @Override
    public List<Compte> findByClientId(int clientId) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if (clientOpt.isPresent()) {
            return new ArrayList<>(clientOpt.get().getcomptesClient());
        }
        return Collections.emptyList();
    }

    @Override
    public List<CompteCourant> findAllComptesCourants() {
        return comptes.values().stream()
                .filter(c -> c instanceof CompteCourant)
                .map(c -> (CompteCourant) c)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompteEpargne> findAllComptesEpargne() {
        return comptes.values().stream()
                .filter(c -> c instanceof CompteEpargne)
                .map(c -> (CompteEpargne) c)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComptePro> findAllComptesPro() {
        return comptes.values().stream()
                .filter(c -> c instanceof ComptePro)
                .map(c -> (ComptePro) c)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Compte> findByNumero(String numero) {
        return findById(numero);
    }

    @Override
    public void addTransaction(String numeroCompte, Transaction transaction) {
        Optional<Compte> compteOpt = findById(numeroCompte);
        compteOpt.ifPresent(compte -> {
            compte.getHistoriqueTransactions().add(transaction);
            // Mettre à jour le solde si nécessaire (selon la logique métier)
            // Par exemple, si c'est un dépôt, ajouter le montant, etc.
            // On peut laisser le service gérer cela, ou le faire ici.
        });
    }
}