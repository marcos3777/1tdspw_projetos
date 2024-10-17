package br.com.fiap.futiba.dao;

import br.com.fiap.futiba.model.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    public void altera(Time time) throws Exception {
        String sql = "update t_time set nome=?, jogos=?, vitorias=?, empates=?, " +
                "gols_pro=?, gols_contra=? where id=?";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);)
        {
            pstmt.setString(1, time.getNome());
            pstmt.setInt(2, time.getJogos());
            pstmt.setInt(3, time.getVitorias());
            pstmt.setInt(4, time.getEmpates());
            pstmt.setInt(5, time.getGolsPro());
            pstmt.setInt(6, time.getGolsContra());
            pstmt.setLong(7, time.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public void insere(Time time) throws Exception {
        String sql = "insert into t_time(nome, jogos, vitorias, empates, " +
                "gols_pro, gols_contra) values(?, ?, ?, ?, ?, ?)";

        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"});) {

            pstmt.setString(1, time.getNome());
            pstmt.setInt(2, time.getJogos());
            pstmt.setInt(3, time.getVitorias());
            pstmt.setInt(4, time.getEmpates());
            pstmt.setInt(5, time.getGolsPro());
            pstmt.setInt(6, time.getGolsContra());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                time.setId(rs.getBigDecimal(1).longValue());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Time> recuperaTudo() throws Exception {
        String sql = "select id, nome, jogos, vitorias, empates, " +
                "gols_pro, gols_contra from t_time";

        List<Time> lista = new ArrayList<>();

        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Time t = new Time();
                t.setId(rs.getLong("id"));
                t.setNome(rs.getString("nome"));
                t.setJogos(rs.getInt("jogos"));
                t.setVitorias(rs.getInt("vitorias"));
                t.setEmpates(rs.getInt("empates"));
                t.setGolsPro(rs.getInt("gols_pro"));
                t.setGolsContra(rs.getInt("gols_contra"));
                lista.add(t);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return lista;
    }

    public Time recuperaPorNome(String nome) throws Exception {
        String sql = "select id, nome, jogos, vitorias, empates, " +
                "gols_pro, gols_contra from t_time where nome=?";

        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);){

            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Time t = new Time();
                t.setId(rs.getLong("id"));
                t.setNome(rs.getString("nome"));
                t.setJogos(rs.getInt("jogos"));
                t.setVitorias(rs.getInt("vitorias"));
                t.setEmpates(rs.getInt("empates"));
                t.setGolsPro(rs.getInt("gols_pro"));
                t.setGolsContra(rs.getInt("gols_contra"));
                return t;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }


}
