package br.unitins.model;

import jakarta.persistence.*;

@Entity
public class Acessorios extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cor cor;
    private String tamanho;
    private Double precoPromocional;

    public Acessorios() {
        // Chama o construtor padrão da classe Produto
        super("", "", 0.0, 0); // Preencha com os valores corretos para os parâmetros do construtor de Produto
    }

    public Acessorios(String nome, String descricao, Double preco, Integer estoque, Cor cor, String tamanho) {
        // Chama o construtor parametrizado da classe Produto
        super(nome, descricao, preco, estoque);
        this.cor = cor;
        this.tamanho = tamanho;
    }


    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
