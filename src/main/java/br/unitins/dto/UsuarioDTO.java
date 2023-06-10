package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(

                @NotBlank(message = "O campo login deve ser informado.") String login,

                @NotBlank(message = "O campo senha deve ser informado.") String senha) {

}
