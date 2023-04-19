package br.unitins.model;

public class Estado {
    
    
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
