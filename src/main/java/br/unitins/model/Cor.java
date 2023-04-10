 package br.unitins.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Cor {
    PRETO(1, "Preto"),
    PRATA(2, "Prata"),
    BRANCO(3, "Branco"),
    VERMELHO(4, "Vermelho"),
    AZUL(5, "Azul");

    private int id;
    private String label;

    Cor(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Cor valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Cor cor : Cor.values()) {
            if (id.equals(cor.getId()))
                return cor;
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}

