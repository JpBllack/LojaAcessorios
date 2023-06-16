package br.unitins.model;

import jakarta.persistence.*;


@Entity
public class Estado extends DefaultEntity{
    
    private String nomeEstado;
    private String sigla;
    
    
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNomeEstado() {
        return nomeEstado;
    }
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
}
