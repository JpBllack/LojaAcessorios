package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.unitins.repository.CompraRepository;
import br.unitins.service.TokenJwtService;
import br.unitins.service.UsuarioService;

import static io.restassured.RestAssured.given;

import jakarta.inject.Inject;


@QuarkusTest
public class CompraResourceTest{
    
    @Inject
    TokenJwtService jwt;

    @Inject
    UsuarioService usuarioService;

    @Inject
    CompraRepository compraRepository;

    @Test
    void testGetAll() {
        given()
        .when().get("/compras")
        .then()
        .statusCode(200);
    }

    @Test
    public void testFindById() {
        Long id = 1l;
        given()
                .when().get("/compras/" + id)
                .then()
                .statusCode(200);
    }

   

}

