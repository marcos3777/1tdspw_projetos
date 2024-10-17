package br.com.fiap.futiba.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {

    public Connection getConexao() throws Exception {
        String us = "pf0313";
        String pw = "professor#23";
        String uri = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        return DriverManager.getConnection(uri, us, pw);
    }

}
