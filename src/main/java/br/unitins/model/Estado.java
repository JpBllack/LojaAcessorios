package br.unitins.model;

import jakarta.persistence.*;


@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEstado;
    private String nomeEstado;
    
    
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
