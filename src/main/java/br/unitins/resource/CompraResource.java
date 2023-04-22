package br.unitins.resource;

import br.unitins.dto.CompraDTO;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;
import br.unitins.service.CompraService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/compras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraResource {

    @Inject
    private CompraService compraService;

    @POST
    public Response insert(CompraDTO compraDTO) {
        Compra compra = new Compra();
        compra.setDataCompra(compraDTO.dataCompra());
        compra.setTotalCompra(compraDTO.totalCompra());
        for (ItemCompraDTO itemCompraDTO : compraDTO.itens()) {
            ItemCompra itemCompra = new ItemCompra();
            itemCompra.setNome(itemCompraDTO.nome());
            itemCompra.setPreco(itemCompraDTO.preco());
            itemCompra.setQuantidade(itemCompraDTO.quantidade());
            compra.addItem(itemCompra);
        }
        Compra compraInserida = compraService.insert(compra);
        return Response.status(Response.Status.CREATED).entity(CompraDTO.convert(compraInserida)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, CompraDTO compraDTO) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        compra.setTotalCompra(compraDTO.totalCompra());
        compra.getItens().clear();
        for (ItemCompraDTO itemCompraDTO : compraDTO.itens()) {
            ItemCompra itemCompra = new ItemCompra();
            itemCompra.setItemcompraId(itemCompraDTO.itemcompraId());
            itemCompra.setNome(itemCompraDTO.nome());
            itemCompra.setPreco(itemCompraDTO.preco());
            itemCompra.setQuantidade(itemCompraDTO.quantidade());
            compra.addItem(itemCompra);
        }
        Compra compraAtualizada = compraService.update(compra);
        return Response.ok(CompraDTO.convert(compraAtualizada)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        compraService.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(CompraDTO.convert(compra)).build();
    }

    @GET
    public Response findAll() {
        List<Compra> compras = compraService.findAll();
        List<CompraDTO> compraDTOs = new ArrayList<>();
        for (Compra compra : compras) {
            compraDTOs.add(CompraDTO.convert(compra));
        }
        return Response.ok(compraDTOs).build();
    }
}
