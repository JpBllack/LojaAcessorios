package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.unitins.model.Usuario;
import br.unitins.service.UsuarioService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private UsuarioService usuarioService;

    @GET
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GET
    @Path("/{id}")
    public Usuario findById(@PathParam("id") Long id) {
        return usuarioService.findById(id);
    }

    @POST
    public Response create(@Valid Usuario usuario) {
        usuarioService.create(usuario);
        return Response.ok(usuario).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid Usuario usuario) {
        usuario.setId(id);
        usuarioService.update(usuario);
        return Response.ok(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.noContent().build();
    }

}
