package br.unitins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private long compraId;
    private Date dataCompra;
    private Double totalCompra;
    private List<ItemCompra> itens;

    public Compra() {
        this.itens = new ArrayList<ItemCompra>();
    }

    public long getCompraId() {
        return compraId;
    }

    public void setCompraId(long compraId) {
        this.compraId = compraId;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    // Adiciona um item à lista de itens da compra
    public void addItem(ItemCompra item) {
        this.itens.add(item);
    }

    // Remove um item da lista de itens da compra
    public void removeItem(ItemCompra item) {
        this.itens.remove(item);
    }

    // Retorna a lista de itens da compra
    public List<ItemCompra> getItens() {
        return itens;
    }
}
