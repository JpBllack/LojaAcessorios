package br.unitins;

/*import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.unitins.dto.CompraDTO;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;
import br.unitins.service.CompraService;
import br.unitins.resource.CompraResource;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompraResourceTest {

    @Mock
    private CompraService compraService;

    @InjectMocks
    private CompraResource compraResource;

    @Test
    public void testInsert() {
        // Cria uma instância de CompraDTO preenchendo seus campos com valores válidos para um teste.
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setDataCompra("03/05/2023");
        compraDTO.setTotalCompra(50.0);
        ItemCompraDTO itemDTO = new ItemCompraDTO();
        itemDTO.setNome("Produto 1");
        itemDTO.setPreco(10.0);
        itemDTO.setQuantidade(5);
        compraDTO.itens().add(itemDTO);

        // Cria um objeto Mock do CompraService que simule seu comportamento sem depender da implementação real.
        when(compraService.insert(Mockito.any(Compra.class))).thenReturn(new Compra());

        // Chama o método insert() da classe CompraResource, passando a instância de CompraDTO criada como argumento.
        Response response = compraResource.insert(compraDTO);

        // Verifica se o Response retornado é válido e que ele contém as informações corretas.
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(CompraDTO.class, response.getEntity().getClass());
    }
}

    
}

*/