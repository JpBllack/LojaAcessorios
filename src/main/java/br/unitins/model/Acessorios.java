package br.unitins.model;

public class Acessorios extends Produto {
    private Cor cor;
    private String tamanho;

    public Acessorios(Long id, String nome, String descricao, Double preco, Integer estoque, Cor cor, String tamanho) {
        super(id, nome, descricao, preco, estoque);
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPrecoPromocional() {
        // Implemente aqui a lógica para calcular o preço promocional do acessório
        return null;
    }
}
