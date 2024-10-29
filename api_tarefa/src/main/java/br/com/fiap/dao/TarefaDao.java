package br.com.fiap.dao;

import br.com.fiap.model.Tarefa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefaDao {

    public List<Tarefa> recupera() throws Exception {
        String sql = "select id, titulo, descricao, prioridade, status, inicio, fim from tarefa";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            List<Tarefa> retorno = new ArrayList<>();
            while (rs.next()) {
                Tarefa t = new Tarefa();
                t.setId(rs.getLong(1));
                t.setTitulo(rs.getString(2));
                t.setDescricao(rs.getString(3));
                t.setPrioridade(rs.getInt(4));
                t.setStatus(rs.getString(5));
                t.setInicio(rs.getDate(6).toLocalDate());
                t.setFim(rs.getDate(7).toLocalDate());
                retorno.add(t);
            }
            return retorno;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public void insere(Tarefa t) throws Exception {

        String sql = "insert into tarefa(titulo, descricao, status, " +
                "inicio, fim, prioridade) values(?, ?, ?, ?, ?, ?)";

        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, t.getTitulo());
            pstmt.setString(2, t.getDescricao());
            pstmt.setString(3, t.getStatus());
            pstmt.setDate(4, Date.valueOf(t.getInicio()));
            pstmt.setDate(5, Date.valueOf(t.getFim()));
            pstmt.setInt(6, t.getPrioridade());

            pstmt.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        /*
        create table tarefa(id number generated by default as identity,
            titulo varchar2(80),
            descricao varchar2(200),
            status varchar2(50),
            inicio  date,
            fim date,
            prioridade number,
            primary key(id));
        */
        Tarefa teste = new Tarefa();
        teste.setTitulo("Checkpoint 5");
        teste.setDescricao("Conteudo de banco de dados");
        teste.setStatus("Incompleto!");
        teste.setInicio(LocalDate.of(2024, 10, 3));
        teste.setFim(LocalDate.of(2024, 10, 13));
        teste.setPrioridade(10);

        TarefaDao banco = new TarefaDao();
        try {
            banco.insere(teste);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
