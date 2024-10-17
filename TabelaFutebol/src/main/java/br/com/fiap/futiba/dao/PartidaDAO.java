package br.com.fiap.futiba.dao;

import br.com.fiap.futiba.model.Partida;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PartidaDAO {

    public void insere(Partida jogo) throws Exception {
        String sql = "insert into t_partida(id_timecasa, id_timevisitante," +
                "gols_casa, gols_visitante) values(?, ?, ?, ?)";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setLong(1, jogo.getCasa().getId());
            pstmt.setLong(2, jogo.getVisitante().getId());
            pstmt.setInt(3, jogo.getGolsCasa());
            pstmt.setInt(4, jogo.getGolsVisitante());

            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
