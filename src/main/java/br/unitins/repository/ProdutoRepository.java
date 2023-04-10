package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.unitins.model.Produto;

@ApplicationScoped
public class ProdutoRepository {
    
    @Inject
    EntityManager em;

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    @Transactional
    public void persist(Produto produto) {
        em.persist(produto);
    }

    @Transactional
    public void update(Produto produto) {
        em.merge(produto);
    }

    @Transactional
    public void delete(Produto produto) {
        em.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto obterProdutoPorId(Long id) {
        return findById(id);
    }

    public void adicionarProduto(Produto produto) {
        persist(produto);
    }
    
    @Transactional
    public Produto atualizarProduto(Produto produto) {
        return em.merge(produto);
    }
    
    

    public void removerProduto(Long id) {
        delete(findById(id));
    }
}
