package br.unitins.service;

import br.unitins.dto.CartaoCreditoDTO;
import br.unitins.dto.CompraResponseDTO;

import java.util.List;

public interface CompraService {

    List<CompraResponseDTO> getAll();

    CompraResponseDTO findById(Long id);

    CompraResponseDTO comprarItens(Long id);

    void efetuarPagamentoPix(Long idUsuario);

    void efetuarPagamentoCartaoCredito(Long idUsuario, CartaoCreditoDTO cartaoCreditoDTO);

}
