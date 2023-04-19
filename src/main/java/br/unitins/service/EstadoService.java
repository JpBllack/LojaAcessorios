package br.unitins.service;

import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EstadoService {

    @Inject
    private EstadoRepository repository;

    public void create(Estado estado) {
        repository.create(estado);
    }

    public Estado findById(Long id) {
        return repository.findById(id);
    }

    public void update(Estado estado) {
        repository.update(estado);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Estado> findAll() {
        return repository.findAll();
    }
}
