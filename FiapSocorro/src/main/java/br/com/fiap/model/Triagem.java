package br.com.fiap.model;

import java.time.LocalDateTime;

public class Triagem {

    private long id;
    private String motivo;
    private double temperatura;
    private double pressao;
    private int batimentos;
    private String gravidade;
    private LocalDateTime dataHora;

    private Funcionario enfermeira;
    private Paciente doente;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isCompleta() {
        if (temperatura == 0 || pressao == 0 || batimentos == 0)
            return false;
        if (enfermeira == null || doente == null)
            return false;
        if (motivo == null || motivo.trim().isEmpty())
            return false;
        return true;
    }


    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public int getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(int batimentos) {
        this.batimentos = batimentos;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public Funcionario getEnfermeira() {
        return enfermeira;
    }

    public void setEnfermeira(Funcionario enfermeira) {
        this.enfermeira = enfermeira;
    }

    public Paciente getDoente() {
        return doente;
    }

    public void setDoente(Paciente doente) {
        this.doente = doente;
    }
}
