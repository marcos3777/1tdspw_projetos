package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Funcionario;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TriagemDAO {

    public void insert(Triagem tri) throws Exception {
        String sql = "insert into tbw_triagem(motivo, temperatura, pressao, batimentos, " +
                "gravidade, datahora, id_doente, id_enfermeira) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, tri.getMotivo());
            pstmt.setDouble(2, tri.getTemperatura());
            pstmt.setDouble(3, tri.getPressao());
            pstmt.setInt(4, tri.getBatimentos());
            pstmt.setString(5, tri.getGravidade());
            pstmt.setTimestamp(6, Timestamp.valueOf(tri.getDataHora()));
            pstmt.setLong(7, tri.getDoente().getId());
            pstmt.setLong(8, tri.getEnfermeira().getId());

            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Triagem> recuperaPorPaciente(long id) throws Exception {

        String sql = "select t.id, t.motivo, t.pressao, t.temperatura, t.batimentos," +
                "t.datahora, f.registro, f.nome, f.cargo from tbw_triagem t " +
                    "inner join tbw_funcionario f on t.id_enfermeira = f.id " +
                    "where t.id_doente = ?";
        List<Triagem> retorno = new ArrayList<>();

        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Triagem tri = new Triagem();
                tri.setId(rs.getLong("id"));
                tri.setMotivo(rs.getString("motivo"));
                tri.setPressao(rs.getDouble("pressao"));
                tri.setTemperatura(rs.getDouble("temperatura"));
                tri.setBatimentos(rs.getInt("batimentos"));
                tri.setDataHora(rs.getTimestamp("datahora").toLocalDateTime());
                tri.setEnfermeira(new Funcionario());
                tri.getEnfermeira().setNome(rs.getString("nome"));
                tri.getEnfermeira().setRegistro(rs.getString("registro"));
                tri.getEnfermeira().setCargo(rs.getString("cargo"));

                retorno.add(tri);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return retorno;
    }
}

