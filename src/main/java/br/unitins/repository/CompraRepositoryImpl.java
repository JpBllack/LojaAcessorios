package br.unitins.repository;

import br.unitins.model.Compra;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraRepositoryImpl implements CompraRepository {

    @PersistenceContext
    private EntityManager em;

    private Map<Long, Compra> compras = new HashMap<>();
    private long nextId = 1;

    @Override
    public Compra insert(Compra compra) {
        compra.setId(nextId);
        compras.put(nextId, compra);
        nextId++;
        return compra;
    }

    @Override
    public Compra update(Compra compra) {
        compras.put(compra.getId(), compra);
        return compra;
    }

    @Override
    public void delete(long compraId) {
        compras.remove(compraId);
    }

    @Override
    public Compra findById(long compraId) {
        return compras.get(compraId);
    }

    @Override
    public List<Compra> findAll() {
        return new ArrayList<>(compras.values());
    }

    @Override
    public void persist(Compra compra) {
        em.persist(compra);
    }
}
