package br.unitins.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.Sexo;
import br.unitins.model.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String cpf,
    String nome,
    String login,
    String senha,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo
) {

    public static UsuarioResponseDTO valueOf(Usuario u) {
        return new UsuarioResponseDTO(u.getId(), 
            u.getCpf(), 
            u.getNome(),
            u.getLogin(),
            u.getSenha(),
            u.getSexo());
    }
}
