package br.unitins.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {

    private String login;
    private String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ElementCollection
    @CollectionTable(name = "perfis", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfil", length = 30)
    private Set<Perfil> perfis;

    @OneToOne
    @JoinColumn(name = "id_telefone_celular", unique = true)
    private Telefone celular;

    @OneToOne
    @JoinColumn(name = "id_telefone_whatsapp", unique = true)
    private Telefone whastapp;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> listaEndereco;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Telefone getWhastapp() {
        return whastapp;
    }

    public void setWhastapp(Telefone whastapp) {
        this.whastapp = whastapp;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

}
