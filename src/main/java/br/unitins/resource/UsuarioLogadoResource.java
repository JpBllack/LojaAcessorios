package br.unitins.resource;



import java.io.IOException;

import javax.print.attribute.standard.Media;

import org.eclipse.microprofile.jwt.JsonWebToken;
import br.unitins.application.Result;
import br.unitins.dto.SenhaDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuariologado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response getUsuario() {
        // Obtendo o login a partir do token
        String login = jwt.getSubject();
        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        return Response.ok(usuario).build();
    }

    @PATCH
    @Path("/senha")
    public Response alterarSenha(SenhaDTO senhaDTO) {
        // Obtendo o login a partir do token
        String login = jwt.getSubject();

        // Verificando se a senha antiga está correta
        boolean senhaCorreta = usuarioService.verificarSenha(login, senhaDTO.getSenhaAntiga());
        if (!senhaCorreta) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Senha antiga incorreta").build();
        }

        // Alterando a senha
        boolean sucesso = usuarioService.alterarSenha(login, senhaDTO.getSenhaAntiga(), senhaDTO.getNovaSenha());
        if (sucesso) {
            return Response.ok("Senha alterada com sucesso").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Falha ao alterar a senha").build();
        }
    }
}

   /*  @PATCH
    @Path("/telefone")
    public Response alterarTelefone(TelefoneDTO telefoneDTO) {
        // Obtendo o login a partir do token
        String login = jwt.getSubject();

        // Alterando o telefone
        boolean sucesso = usuarioService.alterarTelefone(login, telefoneDTO.getTelefone());
        if (sucesso) {
            return Response.ok("Telefone alterado com sucesso").build();
        } else {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Falha ao alterar o telefone").build();
        }
    }

    @PATCH
    @Path("/endereco")
    public Response alterarEndereco(EnderecoDTO enderecoDTO) {
        // Obtendo o login a partir do token
        String login = jwt.getSubject();

        // Alterando o endereço
        boolean sucesso = usuarioService.alterarEndereco(login, enderecoDTO.getEndereco());
        if (sucesso) {
            return Response.ok("Endereço alterado com sucesso").build();
        } else {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Falha ao alterar o endereço").build();
        }
    }  */

