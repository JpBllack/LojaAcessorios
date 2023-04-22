package br.unitins.repository;

import br.unitins.model.Municipio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;

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




