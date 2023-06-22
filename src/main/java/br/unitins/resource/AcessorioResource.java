package br.unitins.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
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
    
    private static final Logger logger = Logger.getLogger(AcessorioResource.class);

    @POST
   // @RolesAllowed({"Admin"})
    public void create(Acessorios acessorios) {
        logger.info("Endpoint: /acessorios (POST)");
        logger.debug("Data: " + acessorios.toString());
        service.create(acessorios);
    }

    @GET
   // @RolesAllowed({"Admin"})
    @Path("/{id}")
    public Acessorios findById(@PathParam("id") Long id) {
        logger.info("Endpoint: /acessorios/{}");
        logger.debug("ID: " + id);
        return service.findById(id);
    }

    @PUT
   // @RolesAllowed({"Admin"})
    public void update(Acessorios acessorios) {
        logger.info("Endpoint: /acessorios (PUT)");
        logger.debug("Data: " + acessorios.toString());
        service.update(acessorios);
    }

    @DELETE
   // @RolesAllowed({"Admin"})
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        logger.info("Endpoint: /acessorios/{} (DELETE)");
        logger.debug("ID: " + id);
        service.delete(id);
    }

    @GET
   // @RolesAllowed({"Admin","User"})
    public List<Acessorios> findAll() {
        logger.info("Endpoint: /acessorios (GET)");
        return service.findAll();
    }
}


