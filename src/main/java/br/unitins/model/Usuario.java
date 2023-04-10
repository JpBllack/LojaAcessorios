package br.unitins.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private List<Endereco> enderecos;
    private List<Acessorios> listaDesejo;
    private List<Telefone> telefones;

    public Usuario(Long id, String nome, String email, String senha, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.enderecos = new ArrayList<>();
        this.listaDesejo = new ArrayList<>();
        this.telefones = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    public List<Acessorios> getListaDesejo() {
        return listaDesejo;
    }

    public void addAcessorioListaDesejo(Acessorios acessorio) {
        this.listaDesejo.add(acessorio);
    }

    public void removeAcessorioListaDesejo(Acessorios acessorio) {
        this.listaDesejo.remove(acessorio);
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public void removeTelefone(Telefone telefone) {
        this.telefones.remove(telefone);
    }
}
