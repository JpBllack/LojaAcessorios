package br.unitins.repository;

import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Categoria;

public class CategoriaRepository {

    private List<Categoria> categorias;

    public CategoriaRepository() {
        categorias = new ArrayList<Categoria>();
    }

    public void create(Categoria categoria) {
        categorias.add(categoria);
    }

    public void update(Categoria categoria) {
        for (Categoria cat : categorias) {
            if (cat.getId().equals(categoria.getId())) {
                cat.setNomeCategoria(categoria.getNomeCategoria());
                break;
            }
        }
    }
    

    public void delete(Categoria categoria) {
        categorias.remove(categoria);
    }

    public List<Categoria> findAll() {
        return categorias;
    }

}

