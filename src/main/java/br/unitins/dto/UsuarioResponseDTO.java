package br.unitins.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.model.Sexo;
import br.unitins.model.Usuario;


public record UsuarioResponseDTO(
    Long id,
    String cpf,
    String nome,
    String email,
    String login,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Sexo sexo
) {

    public static UsuarioResponseDTO valueOf(Usuario u) {
        if (u.getPessoa() == null) 
            return new UsuarioResponseDTO(u.getId(), null, null, null, u.getLogin(), null);
        
        return new UsuarioResponseDTO(u.getId(), 
            u.getPessoa().getCpf(), 
            u.getPessoa().getNome(),
            u.getPessoa().getEmail(),
            u.getLogin(), 
            u.getPessoa().getSexo());
    }


}
