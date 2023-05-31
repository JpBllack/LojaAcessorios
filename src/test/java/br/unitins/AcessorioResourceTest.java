
package br.unitins;

import org.junit.jupiter.api.Test;

import br.unitins.model.Acessorios;
import br.unitins.model.Cor;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcessorioResourceTest {

    private static final String BASE_URL = "http://localhost:8080/acessorios";

    @Test
    public void testCriarAcessorio() {
        Acessorios acessorio = criarAcessorioValido();

        Response response = ClientBuilder.newClient()
                .target(BASE_URL)
                .request()
                .post(Entity.json(acessorio));

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testObterAcessorioPorId() {
        Long id = 1L; // ID do acessório que deseja obter

        Response response = ClientBuilder.newClient()
                .target(BASE_URL)
                .path("/{id}")
                .resolveTemplate("id", id)
                .request()
                .get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testAtualizarAcessorio() {
        Acessorios acessorio = criarAcessorioValido();

        Response response = ClientBuilder.newClient()
                .target(BASE_URL)
                .request()
                .put(Entity.json(acessorio));

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testRemoverAcessorio() {
        Long id = 1L; // ID do acessório que deseja remover

        Response response = ClientBuilder.newClient()
                .target(BASE_URL)
                .path("/{id}")
                .resolveTemplate("id", id)
                .request()
                .delete();

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void testObterTodosAcessorios() {
        Response response = ClientBuilder.newClient()
                .target(BASE_URL)
                .request()
                .get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    private Acessorios criarAcessorioValido() {
        Acessorios acessorio = new Acessorios();
        // Configurar os atributos do acessório para o teste
        acessorio.setNome("Fone de Ouvido");
        acessorio.setDescricao("Fone de ouvido sem fio");
        acessorio.setPreco(99.99);
        acessorio.setEstoque(10);
        acessorio.setCor(Cor.PRETO);
        acessorio.setTamanho("Único");
        acessorio.setPrecoPromocional(79.99);
        return acessorio;
    }
}
