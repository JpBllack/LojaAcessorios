
package br.unitins.model;

public class Telefone {
    private Long id;
    private String codigoArea;
    private String numero;


    public Telefone(Long id, String codigoArea, String numero) {
        this.id = id;
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

