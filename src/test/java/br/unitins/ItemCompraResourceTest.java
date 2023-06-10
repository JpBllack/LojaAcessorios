package br.unitins;



import br.unitins.service.ItemCompraService;
import br.unitins.service.TokenJwtService;
import br.unitins.service.UsuarioServiceImpl;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@QuarkusTest
public class ItemCompraResourceTest {

    @Inject
    ItemCompraService itemCompraSevice;

    @Inject
    TokenJwtService jwt;

    @Inject
    UsuarioServiceImpl usuarioService;

    @Test

    public void testGetAll() {
        given()
                .when().get("/itemCompra")
                .then()
                .statusCode(200);
    }

    @Test
    public void testFindById() {
        Long id = 1l;
        given()
                .when().get("/itemCompra/"+id)
                .then()
                .statusCode(200);
    }

    /*@Test
    public void testCountItensCarrinho() {

        Long userId = 2L;
        Usuario usuario = usuarioService.findById(userId);
        UsuarioResponseDTO usuarioResponse = UsuarioResponseDTO.valueOf(usuario);
        String token = jwt.generateJwt(usuarioResponse);

        given()
        .header("Authorization", "Bearer " + token)
    .when()
        .get("/itemCompra/quantitenscarrinho/")
    .then()
        .statusCode(200);
    }

    @Test
    public void testGetAllCarrinho() {
    Long userId = 2L;
    UsuarioResponseDTO usuarioResponse = usuarioService.findById(userId);
    String token = jwt.generateJwt(usuarioResponse);

        given()
        .header("Authorization", "Bearer " + token)
    .when()
        .get("/itemCompra/itensnocarrinho/")
    .then()
        .statusCode(200);
    }
*/
    @Test
    public void testCount2() {
        given()
                .when().get("/itemCompra/count/")
                .then()
                .statusCode(200);
    }

}
