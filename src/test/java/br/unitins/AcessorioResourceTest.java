package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.dto.AcessorioDTO;
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
        AcessorioDTO ace = new AcessorioDTO("Capinha","capinha mt loka",20.0,"null", "PRETO", "UNICO");
        given()
                .contentType(ContentType.JSON)
                .body(ace)
                .when().post("/acessorios")
                .then()
                .statusCode(201)
                .body("id", notNullValue(),
                        "nome", is("Capinha"),
                        "descricao", is("capinha mt loka"),
                        "preco", is(20.0),
                        "imagemUrl", is("null"),
                        "cor", is ("PRETO"),
                        "tamanho", is ("UNICO")
                        );
    }

    @Test
    public void testUpdate() {
    
        Long id = 1l;
        // Criando outro acessório para atualização
        AcessorioDTO acessorioUpdate = new AcessorioDTO("fone","fonelegal",20.0,"null", "BRANCO", "UNICO");
        given()
                .contentType(ContentType.JSON)
                .body(acessorioUpdate)
                .when().put("/acessorios/" + id)
                .then()
                .statusCode(204);
        // Verificando se os dados foram atualizados no banco de dados
        Acessorios acessorioResponse = acessorioService.findById(id);
        assertThat(acessorioResponse.getNome(), is("fone"));
        assertThat(acessorioResponse.getDescricao(), is("fonelegal"));
        assertThat(acessorioResponse.getPreco(), is(20.0));
        assertThat(acessorioResponse.getNomeImagem(),is ("null"));
        assertThat(acessorioResponse.getCor(), is("BRANCO"));
        assertThat(acessorioResponse.getTamanho(), is("UNICO"));
    }

    @Test
    public void testDelete() {

        Long id =  2l;
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
        Long id = 1l;
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
