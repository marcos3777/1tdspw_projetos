package br.com.fiap.util;

import br.com.fiap.model.Paciente;

import java.time.LocalDate;

public class PacienteTO {

    private String nome;
    private String telefone;
    private String documento;
    private String nascimento;

    public Paciente toPaciente() {
        Paciente pac = new Paciente();
        pac.setNome(nome);
        pac.setDocumento(documento);
        pac.setTelefone(telefone);
        pac.setNascimento(LocalDate.parse(nascimento));
        return pac;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
