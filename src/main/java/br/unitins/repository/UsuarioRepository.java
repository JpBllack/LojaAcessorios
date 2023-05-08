package br.unitins.repository;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.Usuario;

@ApplicationScoped

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void create(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario findById(Long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    

    public void update(Usuario usuario) {
        for (Usuario usu : usuarios) {
            if (usu.getId().equals(usuario.getId())) {
                usu.setNome(usuario.getNome());
                usu.setCpf(usuario.getCpf());
                usu.setEmail(usuario.getEmail());
                usu.setSenha(usuario.getSenha());
                break;
            }
        }
    }

    public void delete(Long id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            usuarios.remove(usuario);
        }
    }
    

    public List<Usuario> findAll() {
        return usuarios;
    }
}
