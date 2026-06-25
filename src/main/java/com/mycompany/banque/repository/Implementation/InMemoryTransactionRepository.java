package com.mycompany.banque.repository.Implementation;
import com.mycompany.banque.entity.Transaction;
import com.mycompany.banque.entity.TypeOperation;
import com.mycompany.banque.entity.Client;
import com.mycompany.banque.entity.Compte;
import com.mycompany.banque.repository.Interface.TransactionRepository;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.time.* ;

public class InMemoryTransactionRepository implements TransactionRepository {

    private final Map<Integer, Transaction> transactions = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    // Pour initialiser, on peut parcourir tous les comptes et récupérer leurs transactions
    public InMemoryTransactionRepository(List<Client> clients) {
        for (Client c : clients) {
            for (Compte compte : c.getcomptesClient()) {
                for (Transaction t : compte.getHistoriqueTransactions()) {
                    transactions.put(t.getIdTransaction(), t);
                    idGenerator.updateAndGet(v -> Math.max(v, t.getIdTransaction() + 1));
                }
            }
        }
    }

    @Override
    public Transaction save(Transaction entity) {
        if (entity.getIdTransaction() == 0) {
            entity.setIdTransaction(idGenerator.getAndIncrement());
        }
        transactions.put(entity.getIdTransaction(), entity);
        return entity;
    }

    @Override
    public Optional<Transaction> findById(Integer id) {
        return Optional.ofNullable(transactions.get(id));
    }

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(transactions.values());
    }

    @Override
    public void deleteById(Integer id) {
        transactions.remove(id);
    }

    @Override
    public void delete(Transaction entity) {
        transactions.remove(entity.getIdTransaction());
    }

    @Override
    public boolean existsById(Integer id) {
        return transactions.containsKey(id);
    }

    @Override
    public long count() {
        return transactions.size();
    }

    @Override
    public List<Transaction> findByCompteNumero(String numeroCompte) {
        // Cette méthode nécessite de parcourir les comptes via un autre repository
        // On peut laisser le service faire la recherche ou utiliser le CompteRepository.
        // Pour simplifier, on peut stocker une map numéroCompte -> liste de transactions
        // mais on ne l'a pas ici. Je vais laisser le service combiner.
        // On peut aussi injecter CompteRepository.
        throw new UnsupportedOperationException("Utilisez plutôt CompteRepository pour obtenir l'historique d'un compte.");
    }

    @Override
    public List<Transaction> findByType(TypeOperation type) {
        return transactions.values().stream()
                .filter(t -> t.getTypeOperation() == type)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByDateBetween(LocalDateTime debut, LocalDateTime fin) {
        return transactions.values().stream()
                .filter(t -> t.getTimeTransaction().isAfter(debut) && t.getTimeTransaction().isBefore(fin))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByMontantBetween(double min, double max) {
        return transactions.values().stream()
                .filter(t -> t.getMontant() >= min && t.getMontant() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByDescriptionContaining(String keyword) {
        return transactions.values().stream()
                .filter(t -> t.getDescription() != null && t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}