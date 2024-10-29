package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {

    public Connection getConexao() throws Exception {
        //Class.forName("");
        String s = System.getenv("USER_ORACLE");
        System.out.println("USER ORACLE " + s);
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, "pf0313",
                                        "professor#23");
    }

    public static void main(String[] args) {
        String s = System.getenv("USER_ORACLE");
        System.out.print(s);
    }


}
