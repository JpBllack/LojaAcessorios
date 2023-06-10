package br.unitins.model;

import jakarta.persistence.*;


@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEstado;
    private String nomeEstado;
    private String sigla;
    
    
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public Long getIdEstado() {
        return IdEstado;
    }
    public void setIdEstado(Long idEstado) {
        IdEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
}
