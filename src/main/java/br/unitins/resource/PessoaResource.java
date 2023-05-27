package br.unitins.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.application.Result;
import br.unitins.dto.PessoaDTO;
import br.unitins.dto.PessoaResponseDTO;
import br.unitins.service.PessoaService;

@Path("/pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {
    
    @Inject
    PessoaService pessoaService;

    @GET
    public List<PessoaResponseDTO> getAll() {
        return pessoaService.getAll();
    }

    @GET
    @Path("/{id}")
    public PessoaResponseDTO findById(@PathParam("id") Long id) {
        return pessoaService.findById(id);
    }

    @POST
    public Response insert(PessoaDTO dto) {
        try {
            PessoaResponseDTO pessoa = pessoaService.create(dto);
            return Response.status(Status.CREATED).entity(pessoa).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PessoaDTO dto) {
        try {
            pessoaService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }      
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pessoaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    public long count(){
        return pessoaService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<PessoaResponseDTO> search(@PathParam("nome") String nome){
        return pessoaService.findByNome(nome);
        
    }
}

