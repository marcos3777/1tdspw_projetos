package br.com.fiap.model;

import java.time.LocalDateTime;

public class Atendimento {

    private long id;
    private LocalDateTime dataHora;
    private String tipo;
    private String descricao;
    private Funcionario funcionario;
    private Paciente doente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Paciente getDoente() {
        return doente;
    }

    public void setDoente(Paciente doente) {
        this.doente = doente;
    }
}
