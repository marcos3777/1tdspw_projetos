package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection getConexao() throws SQLException {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        return DriverManager.getConnection(url, "pf0313", "professor#23");
    }
}
