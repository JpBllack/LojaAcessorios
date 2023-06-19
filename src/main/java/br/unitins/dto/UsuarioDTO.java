package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
         @NotBlank(message = "O campo id deve ser informado.") Long id,
         @NotBlank(message = "O campo cpf deve ser informado.") String cpf,
         @NotBlank(message = "O campo nome deve ser informado.") String nome,
         @NotBlank(message = "O campo login deve ser informado.") String login,
         @NotBlank(message = "O campo senha deve ser informado.") String senha,
         @NotBlank(message = "O campo sexo deve ser informado.") String sexo
        )
{
    
}
