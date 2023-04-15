package br.unitins.dto;

import java.math.BigDecimal;

public record  AcessorioDTO ( String nome,
 String descricao,
 BigDecimal preco,
 String imagemUrl,
String cor,
 String tamanho) {
   

    /*public AcessorioDTO(String nome, String descricao, BigDecimal preco, String imagemUrl, String cor, String tamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.cor = cor;
        this.tamanho = tamanho;
    }*/

   
}
