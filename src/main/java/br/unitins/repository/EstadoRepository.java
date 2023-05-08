package br.unitins.repository;

import br.unitins.model.Estado;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class EstadoRepository {

    @Inject
    private EntityManager em;

    public void create(Estado estado) {
        em.persist(estado);
    }

    public Estado findById(Long id) {
        return em.find(Estado.class, id);
    }

    public void update(Estado estado) {
        em.merge(estado);
    }

    public void delete(Long id) {
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            em.remove(estado);
        }
    }

    public List<Estado> findAll() {
        TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e", Estado.class);
        return query.getResultList();
    }
}
