package br.unitins.resource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.service.ItemCompraService;

@Path("/item-compra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemCompraResource {

    @Inject
    private ItemCompraService itemCompraService;

    @POST
    public Response create(ItemCompraDTO itemCompraDTO) {
        itemCompraService.create(itemCompraDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(ItemCompraDTO itemCompraDTO) {
        itemCompraService.update(itemCompraDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        // Criar um objeto ItemCompraDTO com o id recebido
        ItemCompraDTO itemCompraDTO = new ItemCompraDTO(id, null, 0.0, 0);
    
        // Chamar o método delete do serviço, passando o objeto ItemCompraDTO
        itemCompraService.delete(itemCompraDTO);
    
        return Response.noContent().build();
    }
    

    @GET
    public List<ItemCompraDTO> findAll() {
        return itemCompraService.findAll();
    }

    @GET
    @Path("/{id}")
    public ItemCompraDTO findById(@PathParam("id") long id) {
        return itemCompraService.findById(id);
    }
}
