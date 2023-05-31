package br.unitins.model;
import java.util.List;
import jakarta.persistence.*;

@Entity
public abstract class Produto {

    // Adicione o campo para armazenar os itens de compra relacionados ao produto
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy = "produto")
    private List<ItemCompra> itensCompra;

    private Integer estoque;

    private String nomeImagem;


    

    public Produto(Long id, String nome, String descricao, Double preco, List<ItemCompra> itensCompra,
            Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.itensCompra = itensCompra;
        this.estoque = estoque;
    }

    public Produto() {
        // Construtor padrão vazio
    }
      
     // Adicione os métodos para acessar e manipular a lista de itens de compra
     public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    //metodos 

    public abstract Double getPrecoPromocional();


public void addItemCompra(ItemCompra itemCompra) {
    itensCompra.add(itemCompra);
}

public void removeItemCompra(ItemCompra itemCompra) {
    itensCompra.remove(itemCompra);
}

}
