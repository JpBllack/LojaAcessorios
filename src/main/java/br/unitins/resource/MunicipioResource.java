package br.unitins.resource;

import br.unitins.model.Municipio;
import br.unitins.repository.MunicipioRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MunicipioResource {

    @Inject
    private MunicipioRepository municipioRepository;

    @POST
    public void create(Municipio municipio) {
        municipioRepository.salvar(municipio);
    }

    @GET
    @Path("/{id}")
    public Municipio findById(@PathParam("id") Long id) {
        return municipioRepository.buscarPorId(id);
    }

    @PUT
    public void update(Municipio municipio) {
        municipioRepository.atualizar(municipio);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        municipioRepository.excluir(id);
    }


}
