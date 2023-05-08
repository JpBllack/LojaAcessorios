package br.unitins.service;

import java.util.List;

import br.unitins.model.Compra;
import br.unitins.repository.CompraRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompraService {
    @Inject
    private CompraRepository compraRepository;

    public Compra insert(Compra compra) {
        return compraRepository.insert(compra);
    }

    public Compra update(Compra compra) {
        return compraRepository.update(compra);
    }

    public void delete(long compraId) {
        compraRepository.delete(compraId);
    }

    public Compra findById(long compraId) {
        return compraRepository.findById(compraId);
    }

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }
}
