package br.unitins.model;

import jakarta.persistence.*;

// Definição da classe ItemCompra
@Entity
public class ItemCompra {
    // Atributos da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemcompraId;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    

    private int quantidade;
  

    
    // Métodos de acesso (getters e setters)


    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

     
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getItemcompraId() {
        return itemcompraId;
    }

    public void setItemcompraId(Long itemcompraId) {
        this.itemcompraId = itemcompraId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para calcular o total do item (preço * quantidade)
    public double getTotalItem() {
        return produto.getPreco() * quantidade;
    }
}

