package br.com.fiap;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;
import br.com.fiap.negocio.BusinessPS;
import br.com.fiap.util.PacienteTO;
import br.com.fiap.util.TriagemTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("ps")
public class ProntoSocorroResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("paciente")
    public Response cadastraPaciente(PacienteTO pac) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraPaciente(pac.toPaciente());
            return Response.status(201).entity(pac).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("triagem")
    public Response cadastraTriagem(TriagemTO tri) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraTriagem(tri.toTriagem());
            return Response.status(201).entity(tri).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("atendimento")
    public Response cadastraAtendimento(Atendimento ate) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraAtendimento(ate);
            return Response.status(201).entity(ate).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }


}
