package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.dto.AcessorioDTO;
import br.unitins.dto.AcessorioResponseDTO;
import br.unitins.model.Acessorios;
import br.unitins.service.AcessoriosService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

@QuarkusTest
public class AcessorioResourceTest {

    @Inject
    AcessoriosService acessorioService;

    @Test
    public void testGetAll() {
        given()
                .when().get("/acessorios")
                .then()
                .statusCode(200);
    }

    @Test
    public void testInsert() {
        AcessorioDTO ace = new AcessorioDTO(null, null, null, null, null, null);
        given()
                .contentType(ContentType.JSON)
                .body(ace)
                .when().post("/acessorios")
                .then()
                .statusCode(201)
                .body("id", notNullValue(),
                        "nome", is("Acessorio1"),
                        "descricao", is("Descrição do Acessório 1"),
                        "quantidade", is(10));
    }

    @Test
    public void testUpdate() {
        // Adicionando um acessório no banco de dados
        AcessorioDTO acessorio = new AcessorioDTO(null, null, null, null, null, null);
        Long id = (long) 1;
        // Criando outro acessório para atualização
        AcessorioDTO acessorioUpdate = new AcessorioDTO(null, null, null, null, null, null );
        given()
                .contentType(ContentType.JSON)
                .body(acessorioUpdate)
                .when().put("/acessorios/" + id)
                .then()
                .statusCode(204);
        // Verificando se os dados foram atualizados no banco de dados
        Acessorios acessorioResponse = acessorioService.findById(id);
        assertThat(acessorioResponse.getNome(), is("Acessorio2"));
        assertThat(acessorioResponse.getDescricao(), is("Descrição do Acessório 2"));
        assertThat(acessorioResponse.getEstoque(), is(5));
    }

    @Test
    public void testDelete() {
        // Adicionando um acessório no banco de dados
        AcessorioDTO acessorio = new AcessorioDTO(null, null, null, null, null, null);
        Long id =  (long) 1;
        given()
                .when().delete("/acessorios/" + id)
                .then()
                .statusCode(204);
        // Verificando se o acessório foi excluído do banco de dados
        Acessorios acessorioResponse = null;
        try {
            acessorioResponse = acessorioService.findById(id);
        } catch (Exception e) {
        } finally {
            assertNull(acessorioResponse);
        }
    }

    @Test
    public void testFindById() {
        Long id = 2L;
        given()
                .when().get("/acessorios/" + id)
                .then()
                .statusCode(200);
    }

    @Test
    public void testCount() {
        given()
                .when().get("/acessorios/count")
                .then()
                .statusCode(200);
    }

    @Test
    public void testSearch() {
        String nome = "Acessorio";
        given()
                .when().get("/acessorios/search/" + nome)
                .then()
                .statusCode(200);
    }
}
