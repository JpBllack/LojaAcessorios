package br.unitins.resource;

import br.unitins.model.Municipio;
import br.unitins.repository.MunicipioRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioResource {

    @Inject
    private MunicipioRepository municipioRepository;
    
    private static final Logger logger = Logger.getLogger(MunicipioResource.class);

    @POST
    public void create(Municipio municipio) {
        logger.info("Endpoint: /municipios (POST)");
        logger.debug("recebendo Municipio: {}");
        municipioRepository.salvar(municipio);
    }

    @GET
    @Path("/{id}")
    public Municipio findById(@PathParam("id") Long id) {
        logger.info("Endpoint: /municipios/{} (GET)");
        return municipioRepository.buscarPorId(id);
    }

    @PUT
    public void update(Municipio municipio) {
        logger.info("Endpoint: /municipios (PUT)");
        logger.debug("Received Municipio: {}");
        municipioRepository.atualizar(municipio);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        logger.info("Endpoint: /municipios/{} (DELETE)");
        municipioRepository.excluir(id);
    }
}
