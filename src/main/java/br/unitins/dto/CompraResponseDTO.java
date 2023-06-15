package br.unitins.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;

public record CompraResponseDTO(
    Long id,
    double totalCompra,
    List<Map<String, Object>> listaDeItens
) {
    public CompraResponseDTO(Compra compra) {
        this(compra.getId(), compra.getTotalCompra(), visualizarProdutos(compra.getItens()));
    }

    public static Map<String, Object> encontrarProduto(String nome, double valor, int quant) {
        Map<String, Object> produto = new HashMap<>();
        produto.put("nome", nome);
        produto.put("valor", valor);
        produto.put("quant", quant);
        return produto;
    }

    private static List<Map<String, Object>> visualizarProdutos(Set<ItemCompra> set) {
        List<Map<String, Object>> listaProdutos = new ArrayList<>();
        for (ItemCompra item : set) {
            Map<String, Object> produto = encontrarProduto(item.getProduto().getNome(), item.getProduto().getPreco(), item.getQuantidade());
            listaProdutos.add(produto);
        }
        return listaProdutos;
    }
}
