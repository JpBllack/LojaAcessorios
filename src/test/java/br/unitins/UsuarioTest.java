package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class UsuarioTest {

 @Test
 public void testGetAll() {
 given()
 .when().get("/usuarios")
 .then()
 .statusCode(200);
 }
}