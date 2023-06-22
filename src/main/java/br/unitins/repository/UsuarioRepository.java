package br.unitins.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioRepository.class);
    
    public List<Usuario> findByNome(String nome){
        if (nome == null)
            return null;
            
        return find("UPPER(pessoa.nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }

    public Usuario findByLoginAndSenha(String login, String senha){
        if (login == null || senha == null)
            return null;
            
        return find("login = ?1 AND senha = ?2 ", login, senha).firstResult();
    }

    public Usuario findByLogin(String login) {
        if (login == null)
            return null;

        LOG.debug("Procurando usuário pelo Login: {}", login);

        return find("login", login).firstResult();
    }
}

