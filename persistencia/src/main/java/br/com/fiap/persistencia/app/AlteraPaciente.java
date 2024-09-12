package br.com.fiap.persistencia.app;

import br.com.fiap.persistencia.util.Conexao;

import java.sql.Connection;
import java.sql.Statement;

public class AlteraPaciente {

    public static void main(String[] args) {
        Conexao c = new Conexao();
        try(Connection con = c.getConexao();
            Statement stmt = con.createStatement();) {
            String s;
            s = "update T_paciente set nascimento=TO_DATE('29/08/2024', 'dd/mm/yyyy')";

            stmt.executeUpdate(s);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
