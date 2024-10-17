package br.com.fiap.model;

import java.time.LocalDate;

public class TarefaTO {

    private long id;
    private String titulo;
    private String descricao;
    private String status;
    private String inicio;
    private String fim;
    private int prioridade;

    public Tarefa toTarefa() {
        Tarefa t = new Tarefa();
        t.setId(id);
        t.setTitulo(titulo);
        t.setDescricao(descricao);
        t.setStatus(status);
        t.setPrioridade(prioridade);
        t.setInicio(LocalDate.parse(inicio));
        t.setFim(LocalDate.parse(fim));
        return t;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
