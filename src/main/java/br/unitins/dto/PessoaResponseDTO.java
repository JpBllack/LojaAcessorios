package br.unitins.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.Pessoa;
import br.unitins.model.Sexo;

public record PessoaResponseDTO(
    Long id,
    String cpf,
    String nome,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo
) {
    public PessoaResponseDTO(Pessoa pf) {
        this(pf.getId(), pf.getCpf(), pf.getNome(), pf.getSexo()); 
    }


}
