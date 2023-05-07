package br.unitins;

import static io.restassured.RestAssured.given;


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


}



