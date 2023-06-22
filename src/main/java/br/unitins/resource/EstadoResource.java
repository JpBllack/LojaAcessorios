package br.unitins.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.jboss.logging.Logger;
import br.unitins.application.Result;
import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.service.EstadoService;

@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {
    
    @Inject
    EstadoService estadoService;
    
    private static final Logger logger = Logger.getLogger(EstadoResource.class);

    @GET
    public List<EstadoResponseDTO> getAll() {
        logger.info("Endpoint: /estados (GET)");
        return estadoService.getAll();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Admin","User"})
    public EstadoResponseDTO findById(@PathParam("id") Long id) {
        logger.info("Endpoint: /estados/{}");
        return estadoService.findById(id);
    }

    @POST
   // @RolesAllowed({"Admin"})
    public Response insert(EstadoDTO dto) {
        logger.info("Endpoint: /estados (POST)");
        logger.debug("Data: " + dto.toString());
        try {
            EstadoResponseDTO estado = estadoService.create(dto);
            return Response.status(Status.CREATED).entity(estado).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
   // @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, EstadoDTO dto) {
        logger.info("Endpoint: /estados/{} (PUT)");
        logger.debug("ID: " + id + ", Data: " + dto.toString());
        try {
            EstadoResponseDTO estado = estadoService.update(id, dto);
            return Response.ok(estado).status(Status.NO_CONTENT).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }      
    }

    @DELETE
    @Path("/{id}")
   // @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        logger.info("Endpoint: /estados/{} (DELETE)");
        estadoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
   // @RolesAllowed({"Admin","User"})
    public long count() {
        logger.info("Endpoint: /estados/count (GET)");
        return estadoService.count();
    }

    @GET
    @Path("/search/{nome}")
    //@RolesAllowed({"Admin","User"})
    public List<EstadoResponseDTO> search(@PathParam("nome") String nome) {
        logger.info("Endpoint: /estados/search/{}");
        return estadoService.findByNome(nome);
    }
}
