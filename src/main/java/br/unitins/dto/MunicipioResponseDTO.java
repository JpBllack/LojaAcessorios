package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Municipio;

public record MunicipioResponseDTO (
    Long id,
    String nome,
    Map<String, Object> estado

) {
    public MunicipioResponseDTO(Municipio municipio) {
        this(municipio.getId(),municipio.getNome(),verEstado(municipio.getEstado().getNomeEstado())); 
    }

    public static Map<String, Object> verEstado(String nome) {

        Map<String, Object> estado = new HashMap<>();

        estado.put("nome", nome);

        return estado;
    }

}