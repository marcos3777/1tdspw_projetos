package br.com.fiap.dao;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Funcionario;
import br.com.fiap.model.Triagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {

    public void insert(Atendimento ate) throws Exception {
        String sql = "insert into tbw_atendimento(tipo, descricao, datahora, id_doente, " +
                "id_funcionario) values(?, ?, ?, ?, ?)";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, ate.getTipo());
            pstmt.setString(2, ate.getDescricao());
            pstmt.setTimestamp(3, Timestamp.valueOf(ate.getDataHora()));
            pstmt.setLong(4, ate.getDoente().getId());
            pstmt.setLong(5, ate.getFuncionario().getId());

            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Atendimento> recuperaPorPaciente(long id) throws Exception {
        String sql = "select a.*, f.registro, f.nome, f.cargo from tbw_atendimento a " +
                "inner join tbw_funcionario f on a.id_funcionario = f.id " +
                "where a.id_doente = ?";

        List<Atendimento> retorno = new ArrayList<>();

        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Atendimento ate = new Atendimento();
                ate.setId(rs.getLong("id"));
                ate.setDescricao(rs.getString("descricao"));
                ate.setTipo(rs.getString("tipo"));
                ate.setDataHora(rs.getTimestamp("datahora").toLocalDateTime());
                ate.setFuncionario(new Funcionario());
                ate.getFuncionario().setNome(rs.getString("nome"));
                ate.getFuncionario().setRegistro(rs.getString("registro"));
                ate.getFuncionario().setCargo(rs.getString("cargo"));

                retorno.add(ate);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return retorno;
    }
}
