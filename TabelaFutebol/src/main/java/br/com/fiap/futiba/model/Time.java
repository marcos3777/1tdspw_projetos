package br.com.fiap.futiba.model;

public class Time {

    private long id;
    private String nome;
    private int golsPro;
    private int golsContra;
    private int jogos;
    private int vitorias;
    private int empates;

    public void addJogo() {
        this.jogos++;
    }

    public void addVitoria() {
        this.vitorias++;
    }

    public void addEmpate() {
        this.empates++;
    }

    public void addGolsPro(int gols) {
        this.golsPro = this.golsPro + gols;
    }

    public void addGolsContra(int gols) {
        this.golsContra = this.getGolsContra() + gols;
    }




    public int getSaldoGols() {
        return golsPro - golsContra;
    }

    public int getDerrotas() {
        return jogos - vitorias - empates;
    }

    public int getPontos() {
        return 3 * vitorias + empates;
    }

    public double getAproveitamento() {
        return (this.getPontos() / (jogos * 3.0)) * 100;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
}
