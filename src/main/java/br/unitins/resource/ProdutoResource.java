/*package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.unitins.model.Produto;
import br.unitins.repository.ProdutoRepository;


@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoRepository produtoRepository;

    @GET
    public List<Produto> listar() {
        return produtoRepository.listarProdutos();
    }

    @POST
    public Response criar(Produto produto) {
        produtoRepository.adicionarProduto(produto);
        return Response.status(Response.Status.CREATED).entity(produto).build();
    }

    @GET
    @Path("/{id}")
    public Produto buscarPorId(@PathParam("id") Long id) {
        return produtoRepository.obterProdutoPorId(id);
    }

    @PUT
    @Path("/{id}")
    public Produto atualizar(@PathParam("id") Long id, Produto produto) {
        produto.setId(id);
        return produtoRepository.atualizarProduto(produto);
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        produtoRepository.removerProduto(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
*/