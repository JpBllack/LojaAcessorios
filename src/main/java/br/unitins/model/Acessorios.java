package br.unitins.model;

public class Acessorios extends Produto {


    public Acessorios(String nome, String descricao, Double preco, Integer estoque) {
        super(nome, descricao, preco, estoque);
            }

    private Cor cor;
    private String tamanho;
    private Double precoPromocional;

    
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
        if (this.precoPromocional != null) {
            return this.precoPromocional;
        } else {
            return null;
        }
    }

    public void setPrecoPromocional(Double precoPromocional) {
        this.precoPromocional = precoPromocional;
    }
    
}
