package br.unitins.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.Compra;

@ApplicationScoped
public class CompraRepository {
    private Map<Long, Compra> compras = new HashMap<>();
    private long nextId = 1;

    public Compra insert(Compra compra) {
        compra.setCompraId(nextId);
        compras.put(nextId, compra);
        nextId++;
        return compra;
    }

    public Compra update(Compra compra) {
        compras.put(compra.getCompraId(), compra);
        return compra;
    }

    public void delete(long compraId) {
        compras.remove(compraId);
    }

    public Compra findById(long compraId) {
        return compras.get(compraId);
    }

    public List<Compra> findAll() {
        return new ArrayList<>(compras.values());
    }
}
