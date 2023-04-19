package br.unitins.repository;

import br.unitins.model.Municipio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class MunicipioRepository {

    @PersistenceContext
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

