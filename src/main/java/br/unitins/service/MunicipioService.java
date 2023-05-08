package br.unitins.service;

import br.unitins.model.Municipio;
import br.unitins.repository.MunicipioRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class MunicipioService {

    @Inject
    private MunicipioRepository municipioRepository;

    @Transactional
    public Municipio create(Municipio municipio) {
        
        return municipioRepository.salvar(municipio);
    }

    @Transactional
    public Municipio update(Municipio municipio) {
    
        return municipioRepository.atualizar(municipio);
    }

    public Municipio findById(Long id) {
     
        return municipioRepository.buscarPorId(id);
    }

    @Transactional
    public void delete(Long id) {
        
        municipioRepository.excluir(id);
    }

   
}
