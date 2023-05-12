package br.unitins.service;

import java.util.List;

import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;

public interface UsuarioService {

    // recursos basicos
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    Usuario findByLoginAndSenha(String login, String senha);

  //  UsuarioResponseDTO create(UsuarioDTO UsuarioDTO);

   // UsuarioResponseDTO update(Long id, UsuarioDTO UsuarioDTO);

    void delete(Long id);

    // recursos extras

    List<UsuarioResponseDTO> findByNome(String nome);

    long count();

}
