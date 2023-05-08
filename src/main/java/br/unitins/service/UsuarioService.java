package br.unitins.service;

import java.util.List;

import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioService {

    private UsuarioRepository repository = new UsuarioRepository();

    public void create(Usuario usuario) {
        repository.create(usuario);
    }

    public Usuario findById(Long id) {
        return repository.findById(id);
    }

    public void update(Usuario usuario) {
        repository.update(usuario);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }
}

