package br.com.fiap.util;

import br.com.fiap.model.Funcionario;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;

public class TriagemTO {

    private long id;
    private String gravidade;
    private String motivo;
    private double pressao;
    private double temperatura;
    private int batimentos;
    private long idDoente;
    private long idFuncionario;

    public Triagem toTriagem() {
        Triagem t = new Triagem();
        t.setBatimentos(batimentos);
        t.setPressao(pressao);
        t.setMotivo(motivo);
        t.setGravidade(gravidade);
        t.setTemperatura(temperatura);

        Paciente doente = new Paciente();
        doente.setId(idDoente);
        t.setDoente(doente);

        Funcionario enf = new Funcionario();
        enf.setId(idFuncionario);
        t.setEnfermeira(enf);

        return t;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public long getIdDoente() {
        return idDoente;
    }

    public void setIdDoente(long idDoente) {
        this.idDoente = idDoente;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
