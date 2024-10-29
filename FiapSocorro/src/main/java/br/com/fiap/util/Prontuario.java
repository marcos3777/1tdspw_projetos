package br.com.fiap.util;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {

    private Paciente paciente;
    private List<Triagem> triagens = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

    public void addTriagem(Triagem t) {
        triagens.add(t);
    }

    public void addAtendimento(Atendimento a) {
        atendimentos.add(a);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Triagem> getTriagens() {
        return triagens;
    }

    public void setTriagens(List<Triagem> triagens) {
        this.triagens = triagens;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
