package br.unitins.model;

// Definição da classe ItemCompra
public class ItemCompra {
    // Atributos da classe
    private Long itemcompraId;
    private String nome;        
    private double preco;     
    private int quantidade;    

    
    // Métodos de acesso (getters e setters)

    public Long getItemcompraId() {
        return itemcompraId;
    }

    public void setItemcompraId(Long itemcompraId) {
        this.itemcompraId = itemcompraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para calcular o total do item (preço * quantidade)
    public double getTotalItem() {
        return preco * quantidade;
    }
}

