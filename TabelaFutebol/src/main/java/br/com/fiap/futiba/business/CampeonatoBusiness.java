package br.com.fiap.futiba.business;

import br.com.fiap.futiba.dao.PartidaDAO;
import br.com.fiap.futiba.dao.TimeDAO;
import br.com.fiap.futiba.model.Partida;
import br.com.fiap.futiba.model.Time;

import java.util.List;

public class CampeonatoBusiness {

    public void gravaPartida(Partida jogo) throws Exception {
        TimeDAO dao = new TimeDAO();
        String nomeCasa = jogo.getCasa().getNome();
        Time casa = dao.recuperaPorNome(nomeCasa);
        if (casa == null) {
            dao.insere(jogo.getCasa());
            casa = jogo.getCasa();
        }
        jogo.setCasa(casa);

        String nomeVisitante = jogo.getVisitante().getNome();
        Time visi = dao.recuperaPorNome(nomeVisitante);
        if (visi == null) {
            dao.insere(jogo.getVisitante());
            visi = jogo.getVisitante();
        }
        jogo.setVisitante(visi);

        //jogo.acertoPartida();
        if (jogo.getGolsCasa() > jogo.getGolsVisitante()) {
            jogo.getCasa().addVitoria();
            jogo.getCasa().addJogo();
            jogo.getVisitante().addJogo();
        }
        else if (jogo.getGolsCasa() < jogo.getGolsVisitante()) {
            jogo.getVisitante().addVitoria();
            jogo.getVisitante().addJogo();
            jogo.getCasa().addJogo();
        }
        else {
            jogo.getCasa().addEmpate();
            jogo.getCasa().addJogo();
            jogo.getVisitante().addEmpate();
            jogo.getVisitante().addJogo();
        }
        jogo.getCasa().addGolsPro(jogo.getGolsCasa());
        jogo.getCasa().addGolsContra(jogo.getGolsVisitante());
        jogo.getVisitante().addGolsPro(jogo.getGolsVisitante());
        jogo.getVisitante().addGolsContra(jogo.getGolsCasa());

        dao.altera(jogo.getCasa());
        dao.altera(jogo.getVisitante());

        PartidaDAO pdao = new PartidaDAO();
        pdao.insere(jogo);
    }

    public List<Time> recuperaTimes() throws Exception {
        TimeDAO tdao = new TimeDAO();
        return tdao.recuperaTudo();
    }
}
