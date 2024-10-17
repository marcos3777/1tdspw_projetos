package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("alunos")
public class AlunoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Eduardo Gondo");
        aluno.setRm(5313);
        aluno.setDataAdmissao(LocalDate.of(2010, 2, 1));
        aluno.setEmail("edugondo@fiap.com.br");
        return Response.ok(aluno).build();
    }

}
