package br.unitins.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.unitins.model.Acessorios;

@Named("acessoriosRepository")
@ApplicationScoped

public class AcessoriosRepository {
    
    private List<Acessorios> acessorios;

    public AcessoriosRepository() {
        acessorios = new ArrayList<Acessorios>();
    }

    public void create(Acessorios acessorio) {
        acessorios.add(acessorio);
    }

    public void update(Acessorios acessorio) {
        for (Acessorios acc : acessorios) {
            if (acc.getId().equals(acessorio.getId())) {
                acc.setNome(acessorio.getNome());
                acc.setDescricao(acessorio.getDescricao());
                acc.setPreco(acessorio.getPreco());
                acc.setEstoque(acessorio.getEstoque());
                acc.setCor(acessorio.getCor());
                acc.setTamanho(acessorio.getTamanho());
                break;
            }
        }
    }

    public void delete(Long id) {
        for (Acessorios acc : acessorios) {
            if (acc.getId().equals(id)) {
                acessorios.remove(acc);
                break;
            }
        }
    }
    
    public Acessorios findById(Long id) {
        for (Acessorios acessorio : acessorios) {
            if (acessorio.getId().equals(id)) {
                return acessorio;
            }
        }
        return null;
    }
    

    public List<Acessorios> findAll() {
        return acessorios;
    }

}
