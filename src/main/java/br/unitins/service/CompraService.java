package br.unitins.service;

import java.util.List;

import br.unitins.dto.CartaoCreditoDTO;
import br.unitins.dto.CompraResponseDTO;

public interface CompraService {
    // recursos basicos
    List<CompraResponseDTO> getAll();

    CompraResponseDTO findById(Long id);

    CompraResponseDTO comprarItens(Long idUsuario);

    void efetuarPagamentoPix(Long idUsuario);

    void efetuarPagamentoCartaoCredito(Long idUsuario, CartaoCreditoDTO cartaoCreditoDTO);

}
