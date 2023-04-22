package br.unitins.dto;

import java.util.ArrayList;
import java.util.List;

import br.unitins.model.ItemCompra;

public record ItemCompraDTO(Long itemcompraId,String nome, double preco, int quantidade) {

    public static List<ItemCompraDTO> convertList(List<ItemCompra> items) {
        List<ItemCompraDTO> itemCompraDTOs = new ArrayList<>();
        for (ItemCompra itemCompra : items) {
            ItemCompraDTO itemCompraDTO = new ItemCompraDTO(
                itemCompra.getItemcompraId(),
                itemCompra.getNome(),
                itemCompra.getPreco(),
                itemCompra.getQuantidade()
            );
            itemCompraDTOs.add(itemCompraDTO);
        }
        return itemCompraDTOs;
    }
   
}
