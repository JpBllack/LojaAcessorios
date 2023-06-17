package br.unitins.repository;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import br.unitins.model.ItemCompra;

@ApplicationScoped
public class ItemCompraRepository {

    @PersistenceContext
    private EntityManager em;

    private List<ItemCompra> itensCompra;

    public ItemCompraRepository() {
        itensCompra = new ArrayList<ItemCompra>();
    }

    public void create(ItemCompra itemCompra) {
        itensCompra.add(itemCompra);
    }

    public void update(ItemCompra itemCompra) {
        for (ItemCompra item : itensCompra) {
            if (item.getItemcompraId().equals(itemCompra.getItemcompraId())) {
                // Atualizar os atributos do item de compra
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
        return em.createQuery("SELECT ic FROM ItemCompra ic", ItemCompra.class)
                 .getResultList();
    }
    

    public long count() {
        return 0;
    }
}
