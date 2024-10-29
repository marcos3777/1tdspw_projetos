package br.com.fiap;

import br.com.fiap.dao.TarefaDao;
import br.com.fiap.model.Tarefa;
import br.com.fiap.model.TarefaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("tarefas")
public class TarefaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response recupera() {
        TarefaDao banco = new TarefaDao();
        try {
            List<Tarefa> lista = banco.recupera();
            return Response.status(200).entity(lista).build();
        }
        catch (Exception e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastra(TarefaTO t) {
        //public Response cadastra(Tarefa t) {
        TarefaDao banco = new TarefaDao();
        try {
            banco.insere(t.toTarefa());
            //banco.insere(t);
            return Response.status(201).entity(t).build();

        } catch (Exception e) {
            return Response.status(401).entity(e.getMessage()).build();
        }
    }


}
