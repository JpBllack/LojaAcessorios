package br.unitins.dto;

import java.math.BigDecimal;

public class AcessorioDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String imagemUrl;
    private String cor;
    private String tamanho;

    public AcessorioDTO(String nome, String descricao, BigDecimal preco, String imagemUrl, String cor, String tamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Método para obter apenas a label da cor
    public String getCorLabel() {
        if (this.cor != null) {
            return this.cor;
        }
        return null;
    }
}
