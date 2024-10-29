package br.com.fiap.negocio;

import br.com.fiap.dao.AtendimentoDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.TriagemDAO;
import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;
import br.com.fiap.util.Prontuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BusinessPS {

    public void cadastraPaciente(Paciente p) throws Exception {
        //nao é permitido gravar um paciente com o mesmo número de documento
        if (Math.random() > 0.75) {
            throw new Exception("Já existe paciente com este número de documento!");
        }
        else {
            PacienteDAO dao = new PacienteDAO();
            dao.insert(p);
        }
    }

    public void cadastraTriagem(Triagem tri) throws Exception {
        TriagemDAO dao = new TriagemDAO();
        if (tri.isCompleta()) {
            tri.setDataHora(LocalDateTime.now());
            dao.insert(tri);
        }
        else {
            throw new Exception("Triagem com campos ausentes");
        }
    }

    public void cadastraAtendimento(Atendimento ate) throws Exception {
        AtendimentoDAO dao = new AtendimentoDAO();
        ate.setDataHora(LocalDateTime.now());
        dao.insert(ate);
    }

    public Prontuario recuperaTratamento(Paciente pac) throws Exception {
        TriagemDAO tdao = new TriagemDAO();
        AtendimentoDAO adao = new AtendimentoDAO();

        List<Triagem> listaTriagem = tdao.recuperaPorPaciente(pac.getId());
        List<Atendimento> listaAtendimento = adao.recuperaPorPaciente(pac.getId());
        Prontuario pront = new Prontuario();
        pront.setPaciente(pac);
        pront.setAtendimentos(listaAtendimento);
        pront.setTriagens(listaTriagem);

        return pront;
    }

    public static void main(String[] args) throws Exception {
        Paciente doente = new Paciente();
        doente.setNome("Jane Doe");
        doente.setDocumento("11111");
        doente.setTelefone("(21) 9858-3999");
        doente.setNascimento(LocalDate.of(2010, 1, 15));

        BusinessPS ps = new BusinessPS();
        ps.cadastraPaciente(doente);
    }

}







