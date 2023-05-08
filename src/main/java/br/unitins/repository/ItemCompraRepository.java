package br.unitins.repository;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.ItemCompra;

@ApplicationScoped
public class ItemCompraRepository {

    private List<ItemCompra> itensCompra;

    public ItemCompraRepository() {
        itensCompra = new ArrayList<ItemCompra>();
    }

    public void create(ItemCompra itemCompra) {
        itensCompra.add(itemCompra);
    }

    public void update(ItemCompra itemCompra) {
        for (ItemCompra item : itensCompra) {
            if (item.getNome().equals(itemCompra.getNome())) {
                // Atualizar os atributos do item de compra
                item.setPreco(itemCompra.getPreco());
                item.setQuantidade(itemCompra.getQuantidade());
                break;
            }
        }
    }

    public void delete(ItemCompra itemCompra) {
        itensCompra.remove(itemCompra);
    }
    
    public void deleteById(Long id) {
        itensCompra.removeIf(item -> item.getItemcompraId().equals(id));
    }

    public ItemCompra findById(Long id) {
        for (ItemCompra item : itensCompra) {
            if (item.getItemcompraId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<ItemCompra> findAll() {
        return itensCompra;
    }
}
