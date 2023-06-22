package br.unitins.resource;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.application.Result;
import br.unitins.dto.SenhaDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.form.ImageForm;
import br.unitins.service.FileService;
import br.unitins.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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

    @Inject
    FileService fileService;

    private static final Logger logger = Logger.getLogger(UsuarioLogadoResource.class);

    @GET
    //@RolesAllowed({ "Admin", "User" })
    public Response getUsuario() {
        logger.info("Endpoint: /usuariologado (GET)");

        // obtendo o login a partir do token
        String login = jwt.getSubject();
        logger.debug("Login: {}");

        UsuarioResponseDTO usuarioResponseDTO = usuarioService.findByLogin(login);

        return Response.ok(usuarioResponseDTO).build();
    }

    @PATCH
    @Path("/novaimagem")
    //@RolesAllowed({ "Admin", "User" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ImageForm form) {
        logger.info("Endpoint: /usuariologado/novaimagem (PATCH)");

        String nomeImagem = "";

        try {
            nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNomeImagem());
            logger.debug("Nome da Imagem Salva: {}");
        } catch (IOException e) {
            Result result = new Result(e.getMessage());
            logger.error("Erro ao salvar a imagem do usuário: {}", e.getMessage(), e);
            return Response.status(Status.CONFLICT).entity(result).build();
        }

        String login = jwt.getSubject();
        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);
        logger.debug("Usuário encontrado: {}");

         usuario = usuarioService.update(usuario.id(), nomeImagem);
        logger.debug("Usuário atualizado: {}");

        return Response.ok(usuario).build();
    }

    @GET
    @Path("/download/{nomeImagem}")
    //@RolesAllowed({ "Admin", "User" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        logger.info("Endpoint: /usuariologado/download/{} (GET)");

        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);

        return response.build();
    }

    @PATCH
    @Path("/senha")
    //@RolesAllowed({ "Admin", "User" })
    public Response alterarSenha(SenhaDTO senhaDTO) {
        logger.info("Endpoint: /usuariologado/senha (PATCH)");

        // Obtendo o login a partir do token
        String login = jwt.getSubject();
        logger.debug("Login: {}");

        // Verificando se a senha antiga está correta
        boolean senhaCorreta = usuarioService.verificarSenha(login, senhaDTO.getSenhaAntiga());
        if (!senhaCorreta) {
            logger.info("Senha antiga incorreta");
            return Response.status(Response.Status.BAD_REQUEST).entity("Senha antiga incorreta").build();
        }

        // Alterando a senha
        boolean sucesso = usuarioService.alterarSenha(login, senhaDTO.getSenhaAntiga(), senhaDTO.getNovaSenha());
        if (sucesso) {
            logger.info("Senha alterada com sucesso");
            return Response.ok("Senha alterada com sucesso").build();
        } else {
            logger.error("Falha ao alterar a senha");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Falha ao alterar a senha").build();
        }
    }
}
