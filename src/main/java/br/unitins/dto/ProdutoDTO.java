package br.unitins.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDTO {
    
    public String nome;
    public String descricao;
    public BigDecimal preco;
    public String imagemUrl;
    public CategoriaDTO categoria;
    public List<AcessorioDTO> acessorios;
}
