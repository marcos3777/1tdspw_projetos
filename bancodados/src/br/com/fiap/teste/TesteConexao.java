package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class TesteConexao {
	
	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		Connection con = DriverManager.getConnection(url, "pf0313", "professor#23");
		//System.out.println(con);
		
		String sql = "select sysdate from dual";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			Timestamp time = rs.getTimestamp(1);
			System.out.println(time.toString());
		}
		
		sql = "select id, placa, montadora, modelo from carro";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("placa") +" " + rs.getString("modelo"));
		}
		
		stmt.close();
		con.close();	
	}

}
