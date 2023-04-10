package br.unitins.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import br.unitins.model.Acessorios;
import br.unitins.service.AcessoriosService;

@Path("/acessorios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AcessorioResource {

    @Inject
    private AcessoriosService service;

    @POST
    public void create(Acessorios acessorios) {
        service.create(acessorios);
    }

    @GET
    @Path("/{id}")
    public Acessorios findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    public void update(Acessorios acessorios) {
        service.update(acessorios);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }

    @GET
    public List<Acessorios> findAll() {
        return service.findAll();
    }
}
