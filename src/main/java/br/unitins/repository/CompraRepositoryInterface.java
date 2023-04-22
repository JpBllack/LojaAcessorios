package br.unitins.repository;

import br.unitins.model.Compra;

import java.util.List;

public interface CompraRepositoryInterface {
    Compra insert(Compra compra);
    Compra update(Compra compra);
    void delete(long compraId);
    Compra findById(long compraId);
    List<Compra> findAll();
}
