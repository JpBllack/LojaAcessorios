package br.unitins.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.CartaoCreditoDTO;
import br.unitins.dto.CompraResponseDTO;
import br.unitins.model.BandeiraCartao;
import br.unitins.model.CartaoCredito;
import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;
import br.unitins.model.Pix;
import br.unitins.model.Usuario;
import br.unitins.repository.CartaoCreditoRepository;
import br.unitins.repository.CompraRepository;
import br.unitins.repository.ItemCompraRepository;
import br.unitins.repository.PixRepository;
import br.unitins.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CompraServiceImpl implements CompraService {

    @Inject
    ItemCompraRepository itemCompraRepository;

    @Inject
    CartaoCreditoRepository cartaoCreditoRepository;

    @Inject
    CompraRepository compraRepository;

    @Inject
    PixRepository pixRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<CompraResponseDTO> getAll() {
        List<Compra> list = compraRepository.findAll();
        return list.stream().map(CompraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CompraResponseDTO findById(Long id) {
        Compra compra = compraRepository.findById(id);
        if (compra == null)
            throw new NotFoundException("Compra não encontrada.");
        return new CompraResponseDTO(compra);
    }

    @Override
    @Transactional
    public CompraResponseDTO comprarItens(Long id) {
        double total = 0;
        Compra entity = new Compra();
        List<ItemCompra> listaItens = new ArrayList<>();

        List<ItemCompra> items = itemCompraRepository.findAll();
        for (ItemCompra item : items) {
            if (item.getUsuario().getId().equals(id)) {
                listaItens.add(item);
                total += item.getTotalItem();
            }
        }

        entity.setItens(new HashSet<>(listaItens));
        entity.setTotalCompra(total);
        entity.setUsuario(usuarioRepository.findById(id));

        compraRepository.persist(entity);

        return new CompraResponseDTO(entity);
    }

    @Override
    @Transactional
    public void efetuarPagamentoPix(Long id) {
        Compra compra = compraRepository.findById(id);       
        if (compra == null)
            throw new NotFoundException("Compra não encontrada.");






            Pix pagamento = new Pix(compra.getTotalCompra(), compra.getUsuario().getLogin(),
                compra.getUsuario().getPessoa().getCpf());

        pixRepository.persist(pagamento);

        compra.setPagamento(pagamento);
    }

    @Override
    @Transactional
    public void efetuarPagamentoCartaoCredito(Long id, CartaoCreditoDTO cartaoCreditoDTO) {
        Usuario usuario = usuarioRepository.findById(id);
        Compra compra = compraRepository.findById(id);      
        if (compra == null)
            throw new NotFoundException("Compra não encontrada.");

        CartaoCredito pagamento = new CartaoCredito(compra.getTotalCompra(), cartaoCreditoDTO.numeroCartao(),
                cartaoCreditoDTO.nomeImpressoCartao(), usuario.getPessoa().getCpf(),
                BandeiraCartao.valueOf(cartaoCreditoDTO.bandeiraCartao()));

        cartaoCreditoRepository.persist(pagamento);

        compra.setPagamento(pagamento);
    }
}
