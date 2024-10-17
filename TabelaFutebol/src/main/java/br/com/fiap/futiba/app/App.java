package br.com.fiap.futiba.app;

import br.com.fiap.futiba.business.CampeonatoBusiness;
import br.com.fiap.futiba.model.Partida;
import br.com.fiap.futiba.model.Time;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Time pal = new Time();
        pal.setNome("Palmeiras");
        Time sao = new Time();
        sao.setNome("São Paulo");
        Time juv = new Time();
        juv.setNome("Juventus");
        Time cor = new Time();
        cor.setNome("Corinthians");

        Partida p1 = new Partida();
        p1.setCasa(pal);
        p1.setVisitante(sao);
        p1.setGolsCasa(2);
        p1.setGolsVisitante(2);

        Partida p2 = new Partida();
        p2.setCasa(juv);
        p2.setVisitante(cor);
        p2.setGolsVisitante(1);
        p2.setGolsCasa(0);

        Partida p3 = new Partida();
        p3.setCasa(cor);
        p3.setVisitante(pal);
        p3.setGolsCasa(2);
        p3.setGolsVisitante(4);

        CampeonatoBusiness neg = new CampeonatoBusiness();
        try {
            neg.gravaPartida(p1);
            neg.gravaPartida(p2);
            neg.gravaPartida(p3);

            List<Time> lista = neg.recuperaTimes();
            for(Time t : lista) {
                System.out.println(t.getNome() + " " + t.getPontos() + " " + t.getJogos());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
