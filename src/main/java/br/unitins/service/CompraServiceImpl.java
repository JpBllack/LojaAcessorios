package br.unitins.service;

import java.util.ArrayList;
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
        List<Compra> list = compraRepository.listAll();
        return list.stream().map(CompraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CompraResponseDTO findById(Long id) {
        Compra compra = compraRepository.findById(id);
        if (compra == null)
            throw new NotFoundException("compra não encontrada.");
        return new CompraResponseDTO(compra);
    }

    @Override
    @Transactional
    public CompraResponseDTO comprarItens(Long idUsuario) {
        double total = 0;
        Compra entity = new Compra();
        long cont = itemCompraRepository.count();
        List<ItemCompra> listaItens = new ArrayList<ItemCompra>();

        while(cont > 0){
            ItemCompra item = itemCompraRepository.findById(cont);
            if (item.getUsuario().getId() == idUsuario){
                listaItens.add(item);
                total = total + item.getTotalItem();
            }
            cont--;
        }

        entity.setListaDeItens(listaItens);
        entity.setTotalCompra(total);
        entity.setUsuario(usuarioRepository.findById(idUsuario));

        compraRepository.persist(entity);

        return new CompraResponseDTO(entity);
    }

    @Override
    @Transactional
    public void efetuarPagamentoPix(Long idUsuario) {

        Compra compra = new Compra();
        long cont = compraRepository.count();

        while(cont > 0){
            Compra compr = compraRepository.findById(cont);
            if(compr.getUsuario().getId() == idUsuario){
                compra = compraRepository.findById(cont);
            }
            cont--;
        }

        Pix pagamento = new Pix(compra.getTotalCompra(), compra.getUsuario().getLogin(), compra.getUsuario().getPessoa().getCpf());

        pixRepository.persist(pagamento);

        compra.setPagamento(pagamento);

    }

    @Override
    @Transactional
    public void efetuarPagamentoCartaoCredito(Long idUsuario, CartaoCreditoDTO cartaoCreditoDTO) {
        
        Usuario usuario = usuarioRepository.findById(idUsuario);

        Compra compra = new Compra();
        long cont = compraRepository.count();

        while(cont > 0){
            Compra compr = compraRepository.findById(cont);
            if(compr.getUsuario().getId() == idUsuario){
                compra = compraRepository.findById(cont);
            }
            cont--;
        }

        CartaoCredito pagamento = new CartaoCredito(compra.getTotalCompra(),
                                            cartaoCreditoDTO.numeroCartao(),
                                            cartaoCreditoDTO.nomeImpressoCartao(),
                                            usuario.getPessoa().getCpf(),
                                            BandeiraCartao.valueOf(cartaoCreditoDTO.bandeiraCartao()));
        
        cartaoCreditoRepository.persist(pagamento);

        compra.setPagamento(pagamento);
    }
    
}
