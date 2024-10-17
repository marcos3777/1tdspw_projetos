package br.com.fiap.resource;

import br.com.fiap.futiba.business.CampeonatoBusiness;
import br.com.fiap.futiba.model.Partida;
import br.com.fiap.futiba.model.Time;
import br.com.fiap.model.Carta;
import br.com.fiap.model.PartidaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("resource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/carta")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarta() {
        Carta c = new Carta();
        c.setNaipe("Paus");
        c.setValor(12);
        return Response.ok(c).build();
    }

    @POST
    @Path("/carta")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCarta(Carta c, @Context UriInfo uriInfo) {
        System.out.println("Carta " + c.getValor() + c.getNaipe());
        URI uri = uriInfo.getAbsolutePath();
        System.out.println(uri.toString());
        return Response.status(201).entity(uri.toString()).build();
    }

    @GET
    @Path("/times")
    public Response recuperaTimes() {
        CampeonatoBusiness cb = new CampeonatoBusiness();
        try {
            List<Time> times = cb.recuperaTimes();
            return Response.ok(times).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/partidas")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastraPartida(PartidaTO part) {
        System.out.print(part.getVisitante() + " " + part.getCasa());
        CampeonatoBusiness cb = new CampeonatoBusiness();
        Partida p = new Partida();
        p.setGolsVisitante(part.getGv());
        p.setGolsCasa(part.getGc());

        Time aux = new Time();
        aux.setNome(part.getCasa());
        p.setCasa(aux);

        aux = new Time();
        aux.setNome(part.getVisitante());
        p.setVisitante(aux);

        try {
            cb.gravaPartida(p);
            return Response.ok(p).build();

        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
    //{"casa": "Palmeiras", "visitante": "Juventus", "gc": 2, "gv": 1}


}
