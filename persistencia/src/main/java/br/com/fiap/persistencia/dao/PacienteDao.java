package br.com.fiap.persistencia.dao;

import br.com.fiap.persistencia.model.Paciente;
import br.com.fiap.persistencia.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    public void inclui(Paciente pac) throws Exception {
        Conexao c = new Conexao();
        String sql = "insert into t_paciente (nome, telefone, email, responsavel, cpf, nascimento) " +
                "values(? , ?, ?, ?, ?, ?)";

        try (Connection con = c.getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, pac.getNome());
            pstmt.setString(2, pac.getTelefone());
            pstmt.setString(3, pac.getEmail());
            pstmt.setString(4, pac.getResponsavel());
            pstmt.setLong(5, pac.getCpf());
            pstmt.setDate(6, Date.valueOf(pac.getNascimento()));
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Paciente recupera(long id) throws Exception {
        Conexao c = new Conexao();
        String sql = "select id, nome, nascimento, email, cpf, telefone, responsavel " +
                "from t_paciente where id = ?";
        Paciente paciente = null;
        try(Connection con = c.getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setId(id);
                paciente.setCpf(rs.getLong("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setResponsavel(rs.getString("responsavel"));
                paciente.setNascimento(rs.getDate("nascimento").toLocalDate());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public List<Paciente> recupera() throws Exception {
        List<Paciente> lista = new ArrayList<>();
        Conexao c = new Conexao();
        String sql = "select id, nome, nascimento, email, cpf, telefone, responsavel " +
                "from t_paciente order by nome";
        Paciente paciente = null;
        try (Connection con = c.getConexao();
             PreparedStatement pstmt = con.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getLong("id"));
                paciente.setCpf(rs.getLong("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setResponsavel(rs.getString("responsavel"));
                paciente.setNascimento(rs.getDate("nascimento").toLocalDate());
                lista.add(paciente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public static void main(String[] args) {
        Paciente p = new Paciente();
        p.setNascimento(LocalDate.of(2004, 8, 23));
        p.setCpf(234938928);
        p.setNome("Eduardo Gondo");
        p.setEmail("profeduardo@fiap.com.br");
        p.setTelefone("234230494");
        p.setResponsavel(null);

        PacienteDao pdao = new PacienteDao();
        try {
            pdao.inclui(p);
            Paciente teste = pdao.recupera(1);
            System.out.println(teste.getNome() + " " + teste.getEmail());

            List<Paciente> lista = pdao.recupera();
            for(Paciente pac : lista) {
                System.out.println(pac.getNome() + " " + pac.getNascimento());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
