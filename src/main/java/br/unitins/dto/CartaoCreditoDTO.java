package br.unitins.dto;

import java.time.LocalDate;

public record CartaoCreditoDTO(
    String numeroCartao,
    String nomeImpressoCartao,
    LocalDate dataValidade,
    String codigoSeguranca,
    Integer bandeiraCartao
) {
    
}
