package com.mycompany.banque.repository.Implementation;

import com.mycompany.banque.Client;
import com.mycompany.banque.Compte;
import com.mycompany.banque.repository.Interface.ClientRepository;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryClientRepository implements ClientRepository {

    private final Map<Integer, Client> clients = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    // Initialisation avec la liste fournie par DataInitializer
    public InMemoryClientRepository(List<Client> initialClients) {
        if (initialClients != null) {
            for (Client c : initialClients) {
                clients.put(c.getId(), c);
                // mettre à jour le générateur pour éviter les conflits
                idGenerator.updateAndGet(v -> Math.max(v, c.getId() + 1));
            }
        }
    }

    @Override
    public Client save(Client entity) {
        if (entity.getId() == 0) {
            entity.setId(idGenerator.getAndIncrement());
        }
        clients.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return Optional.ofNullable(clients.get(id));
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public void deleteById(Integer id) {
        clients.remove(id);
    }

    @Override
    public void delete(Client entity) {
        clients.remove(entity.getId());
    }

    @Override
    public boolean existsById(Integer id) {
        return clients.containsKey(id);
    }

    @Override
    public long count() {
        return clients.size();
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clients.values().stream()
                .filter(c -> c.getAdresseMail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<Client> findByNom(String nom) {
        return clients.values().stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByPrenom(String prenom) {
        return clients.values().stream()
                .filter(c -> c.getPrenom().equalsIgnoreCase(prenom))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findClientByCompte(Compte compte) {
        return clients.values().stream()
                .filter(c -> c.getcomptesClient().contains(compte))
                .findFirst();
    }

    @Override
    public Optional<Client> findClientByCompteNumero(String numeroCompte) {
        return clients.values().stream()
                .filter(c -> c.getcomptesClient().stream().anyMatch(comp -> comp.getNumeroCompte().equals(numeroCompte)))
                .findFirst();
    }
}