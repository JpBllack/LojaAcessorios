package br.unitins;

/*import static io.restassured.RestAssured.given;


import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import br.unitins.model.Acessorios;
import br.unitins.model.Cor;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AcessorioTest {

    @Test
    public void testCreate() {
        Acessorios acessorio = new Acessorios();
        acessorio.setNome("Relógio Digital");
        acessorio.setDescricao("Relógio digital de pulso");
        acessorio.setPreco(100.0); 
        acessorio.setCor(Cor.PRETO);
        acessorio.setTamanho("m");
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(acessorio)
        .when()
            .post("/acessorios")
        .then()
            .statusCode(204);
    }

    @Test
    public void testFindById() {
        given()
            .pathParam("id", 1)
        .when()
            .get("/acessorios/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("nome", equalTo("Relógio Digital"))
            .body("descricao", equalTo("Relógio digital de pulso"))
            .body("preco", equalTo(100.0f))
            .body("cor", equalTo("preto"))
            .body("tamanho", equalTo("m"));
    }

    @Test
    public void testUpdate() {
        Acessorios acessorio = new Acessorios();
        acessorio.setId((long) 1);
        acessorio.setNome("Relógio Digital");
        acessorio.setDescricao("Relógio digital de pulso");
        acessorio.setPreco(200.0);
        acessorio.setCor(Cor.AZUL);
        acessorio.setTamanho("p");
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(acessorio)
        .when()
            .put("/acessorios")
        .then()
            .statusCode(204);
    }

    @Test
    public void testDelete() {
        given()
            .pathParam("id", 1)
        .when()
            .delete("/acessorios/{id}")
        .then()
            .statusCode(204);
    }

}*/



