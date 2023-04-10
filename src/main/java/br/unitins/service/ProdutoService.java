package br.unitins.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.unitins.model.Produto;
import br.unitins.repository.ProdutoRepository;

import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.obterProdutoPorId(id);
    }

    public void adicionarProduto(Produto produto) {
        produtoRepository.adicionarProduto(produto);
    }

    public void atualizarProduto(Produto produto) {
        produtoRepository.atualizarProduto(produto);
    }

    public void removerProduto(Long id) {
        produtoRepository.removerProduto(id);
    }
}
