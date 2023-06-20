package br.unitins.service;

import java.util.List;

import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Usuario;

public interface UsuarioService {

    // recursos basicos
    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    Usuario findByLoginAndSenha(String login, String senha);

    UsuarioResponseDTO findByLogin(String login);

    UsuarioResponseDTO create(UsuarioDTO dto);

    UsuarioResponseDTO update(Long id, UsuarioDTO dto);

    UsuarioResponseDTO update(Long id, String nomeImagem);

    void delete(Long id);

    // recursos extras

    List<UsuarioResponseDTO> findByNome(String nome);

    long count();

    boolean verificarSenha(String login, String senhaAntiga);

	boolean alterarSenha(String login, String senhaAntiga, String novaSenha);

    
}
