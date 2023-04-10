package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
