
package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import br.unitins.service.HashService;
import br.unitins.service.UsuarioService;

import static io.restassured.RestAssured.given;
import jakarta.inject.Inject;


@QuarkusTest
public class UsuarioTest {

@Inject
UsuarioService usuarioService;

@Inject
HashService hashService;

@Test

public void testGetAll() {
given()
.when().get("/compras")
.then()
.statusCode(200);
}


@Test

public void testFindById() {
Long id = 2l;
given()
.when().get("/usuarios/" + id)
.then()
.statusCode(200);
}

@Test

public void testCount() {
given()
.when().get("/usuarios/count")
.then()
.statusCode(200);
}

@Test

public void testSearch() {

String loginUsu = "Erick";

given()
.when().get("/usuarios/search/" + loginUsu)
.then()
.statusCode(200);
}

@Test

public void testGetListaDesejo() {
Long id = 1l;
given()
.when().get("/usuarios/listadesejo/" + id)
.then()
.statusCode(200);
}

}
 