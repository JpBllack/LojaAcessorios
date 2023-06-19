package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.application.Result;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.service.UsuarioService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    @Path("/get")
    public List<UsuarioResponseDTO> getAll() {
        return usuarioService.getAll();
    }

    @GET
    @Path("/{id}")
    public UsuarioResponseDTO findById(@PathParam("id") Long id) {
        return usuarioService.findById(id);
    }

    @POST
    @Path("/usuarios")
    public Response insert(UsuarioDTO dto) {
        try {
            UsuarioResponseDTO usuarioResponseDTO = usuarioService.create(dto);
            return Response.status(Status.CREATED).entity(usuarioResponseDTO).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.BAD_REQUEST).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, UsuarioDTO dto) {
        try {
            usuarioService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.BAD_REQUEST).entity(result).build();
        } catch (NotFoundException e) {
            return Response.status(Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return usuarioService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<UsuarioResponseDTO> search(@PathParam("nome") String nome) {
        return usuarioService.findByNome(nome);

    }
}
