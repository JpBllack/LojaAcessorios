package br.unitins.model;

import java.util.List;

import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"itensCompra"})
public class Acessorios extends Produto {

    public Acessorios() {
        // Construtor padrão vazio
    }

   
    public Acessorios(Long id, String nome, String descricao, Double preco, List<ItemCompra> itensCompra,
            Integer estoque, Cor cor, String tamanho, Double precoPromocional) {
        super(id, nome, descricao, preco, itensCompra, estoque);
        this.cor = cor;
        this.tamanho = tamanho;
        this.precoPromocional = precoPromocional;
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


    @Override
    public void addItemCompra(ItemCompra itemCompra) {
        // TODO Auto-generated method stub
        super.addItemCompra(itemCompra);
    }


    @Override
    public void removeItemCompra(ItemCompra itemCompra) {
        // TODO Auto-generated method stub
        super.removeItemCompra(itemCompra);
    }
    
}
