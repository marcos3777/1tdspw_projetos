package br.com.fiap.persistencia.app;

import br.com.fiap.persistencia.util.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultaPaciente {

    public static void main(String[] args) {
        Conexao c = new Conexao();
        try (Connection con = c.getConexao();
            Statement stmt = con.createStatement()) {

            String sql = "select id, nome, telefone, email, responsavel, cpf, nascimento from t_paciente";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("nome") + " " + rs.getString("telefone"));
                System.out.println(rs.getString("email") + " " + rs.getDate("nascimento"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
