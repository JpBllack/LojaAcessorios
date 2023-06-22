package br.unitins.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.jboss.logging.Logger;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.service.ItemCompraService;

@Path("/item-compra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemCompraResource {

    @Inject
    private ItemCompraService itemCompraService;
    
    private static final Logger logger = Logger.getLogger(ItemCompraResource.class);

    @POST
    public Response create(ItemCompraDTO itemCompraDTO) {
        logger.info("Endpoint: /item-compra (POST)");
        logger.debug("Data: " + itemCompraDTO.toString());
        itemCompraService.create(itemCompraDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(ItemCompraDTO itemCompraDTO) {
        logger.info("Endpoint: /item-compra (PUT)");
        logger.debug("Data: " + itemCompraDTO.toString());
        itemCompraService.update(itemCompraDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        logger.info("Endpoint: /item-compra/{} (DELETE)");
        // Criar um objeto ItemCompraDTO com o id recebido
        ItemCompraDTO itemCompraDTO = new ItemCompraDTO(id, null, 0.0, 0);
    
        // Chamar o método delete do serviço, passando o objeto ItemCompraDTO
        itemCompraService.delete(itemCompraDTO);
    
        return Response.noContent().build();
    }

    @GET
    public List<ItemCompraDTO> findAll() {
        logger.info("Endpoint: /item-compra (GET)");
        return itemCompraService.findAll();
    }

    @GET
    @Path("/{id}")
    public ItemCompraDTO findById(@PathParam("id") long id) {
        logger.info("Endpoint: /item-compra/{} (GET)");
        return itemCompraService.findById(id);
    }
}
