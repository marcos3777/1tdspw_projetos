package br.com.fiap.dao;

import br.com.fiap.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PessoaDAO {

    public void insert(Pessoa p) throws SQLException {
        Connection con = new Conexao().getConexao();
        String ins = "insert into pessoa(nome, email, " +
                "sexo, logradouro, cidade, uf) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(ins, new String[]{"id"});
        pstmt.setString(1, p.getNome());
        pstmt.setString(2, p.getEmail());
        pstmt.setString(3, p.getSexo());
        pstmt.setString(4, p.getLogradouro());
        pstmt.setString(5, p.getCidade());
        pstmt.setString(6, p.getUf());
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next())
            p.setId(rs.getBigDecimal(1).longValue());
    }
}
