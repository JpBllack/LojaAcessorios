package br.unitins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.*;

public class CompraResourceTest {
    
    private CompraService compraService;
    private CompraResource compraResource;

    @BeforeEach
    public void beforeEach() {
        compraService = mock(CompraService.class);
        compraResource = new CompraResource();
        compraResource.setCompraService(compraService);
    }

    @Test
    public void testInsert() {
        // cria um objeto CompraDTO para ser enviado no body do POST
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setDataCompra("2022-05-03");
        compraDTO.setTotalCompra(100.0);
        ItemCompraDTO itemCompraDTO = new ItemCompraDTO();
        itemCompraDTO.setNome("Item 1");
        itemCompraDTO.setPreco(50.0);
        itemCompraDTO.setQuantidade(2);
        compraDTO.getItens().add(itemCompraDTO);

        // simula o comportamento do método "insert" da classe CompraService
        when(compraService.insert(any(Compra.class))).thenReturn(new Compra());

        // chama o método insert do CompraResource e guarda a resposta em uma variável
        Response response = compraResource.insert(compraDTO);

        // verifica se a resposta retornada tem status 201 CREATED
        Assertions.assertEquals(201, response.getStatus());

        // verifica se o método "insert" da classe CompraService foi chamado pelo menos uma vez
        verify(compraService, times(1)).insert(any(Compra.class));
    }
}
