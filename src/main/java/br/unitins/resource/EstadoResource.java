package br.unitins.resource;

import br.unitins.model.Estado;
import br.unitins.service.EstadoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class EstadoResource {

    @Inject
    private EstadoService service;

    @POST
    public void create(Estado estado) {
        service.create(estado);
    }

    @GET
    @Path("/{id}")
    public Estado findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    public void update(Estado estado) {
        service.update(estado);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }

    @GET
    public List<Estado> findAll() {
        return service.findAll();
    }
}