package br.com.fiap.dao;

import br.com.fiap.model.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PacienteDAO {

    public void insert(Paciente pac) throws Exception {
        String sql = "insert into tbw_paciente(nome, documento, nascimento, " +
                "telefone) values(?, ?, ?, ?)";
        try(Connection con = new ConexaoFactory().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, pac.getNome());
            pstmt.setString(2, pac.getDocumento());
            pstmt.setDate(3, Date.valueOf(pac.getNascimento()));
            pstmt.setString(4, pac.getTelefone());
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
