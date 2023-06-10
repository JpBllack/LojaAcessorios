package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.model.Estado;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EntityManager em;

    @Override
    public List<EstadoResponseDTO> getAll() {
        List<Estado> estados = em.createQuery("SELECT e FROM Estado e", Estado.class)
                .getResultList();

        return estados.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            return mapToResponseDTO(estado);
        }
        return null;
    }

    @Override
    @Transactional
    public EstadoResponseDTO create(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setNomeEstado(dto.nome());
        estado.setSigla(dto.sigla());

        em.persist(estado);
        em.flush();

        return mapToResponseDTO(estado);
    }

    @Override
    @Transactional
    public EstadoResponseDTO update(Long id, EstadoDTO dto) {
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            estado.setNomeEstado(dto.nome());
            estado.setSigla(dto.sigla());

            estado = em.merge(estado);
            em.flush();

            return mapToResponseDTO(estado);
        }
        return null;
    }

    private EstadoResponseDTO mapToResponseDTO(Estado estado) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Estado estado = em.find(Estado.class, id);
        if (estado != null) {
            em.remove(estado);
            em.flush();
        }
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        List<Estado> estados = em.createQuery("SELECT e FROM Estado e WHERE e.nome LIKE :nome", Estado.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();

        return estados.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

   @Override
    public long count() {
        // Implemente o código para contar o número de estados
        return 0;
    }

}
