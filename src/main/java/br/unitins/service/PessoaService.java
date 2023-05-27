package br.unitins.service;

import java.util.List;

import br.unitins.dto.PessoaDTO;
import br.unitins.dto.PessoaResponseDTO;

public interface PessoaService {

    // recursos basicos
    List<PessoaResponseDTO> getAll();

    PessoaResponseDTO findById(Long id);

    PessoaResponseDTO create(PessoaDTO pessoaDTO);

    PessoaResponseDTO update(Long id, PessoaDTO pessoaDTO);

    void delete(Long id);

    // recursos extras

    List<PessoaResponseDTO> findByNome(String nome);

    long count();

}
