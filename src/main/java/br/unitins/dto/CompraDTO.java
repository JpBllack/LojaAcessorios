/*package br.unitins.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;

public record CompraDTO(Long compraId, double totalCompra, List<ItemCompraDTO> itens, Date dataCompra) {
    public static CompraDTO convert(Compra compra) {
        List<ItemCompraDTO> itemCompraDTOs = new ArrayList<>();
        for (ItemCompra itemCompra : compra.getItens()) {
            ItemCompraDTO itemCompraDTO = new ItemCompraDTO(
                    itemCompra.getItemcompraId(),
                    itemCompra.getProduto().getNome(),
                    itemCompra.getProduto().getPreco(),
                    itemCompra.getQuantidade()
            );
            itemCompraDTOs.add(itemCompraDTO);
        }
        return new CompraDTO(
                compra.getCompraId(),
                compra.getTotalCompra(),
                itemCompraDTOs,
                compra.getDataCompra() // Passa a data de compra durante a conversão
        );
    }
}*/

