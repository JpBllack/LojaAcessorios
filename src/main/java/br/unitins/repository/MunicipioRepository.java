package br.unitins.repository;

import br.unitins.model.Municipio;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MunicipioRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Municipio salvar(Municipio municipio) {
        return em.merge(municipio);
    }

    @Transactional
    public Municipio atualizar(Municipio municipio) {
        return em.merge(municipio);
    }

    public Municipio buscarPorId(Long id) {
        return em.find(Municipio.class, id);
    }

    @Transactional
    public void excluir(Long id) {
        Municipio municipio = em.find(Municipio.class, id);
        if (municipio != null) {
            em.remove(municipio);
        }
    }

}




