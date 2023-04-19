package br.unitins.dto;

import br.unitins.model.Acessorios;

public class AcessorioResponseDTO {

    private String nome;
    private String descricao;
    private String corNome;

    public AcessorioResponseDTO(Acessorios acessorios) {
        this.nome = acessorios.getNome();
        this.descricao = acessorios.getDescricao();
        this.corNome = acessorios.getCor().getLabel();
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

    public String getCorNome() {
        return corNome;
    }

    public void setCorNome(String corNome) {
        this.corNome = corNome;
    }


}
