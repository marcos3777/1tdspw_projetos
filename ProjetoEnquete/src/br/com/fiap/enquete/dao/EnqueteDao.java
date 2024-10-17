package br.com.fiap.enquete.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.enquete.model.Enquete;

public class EnqueteDao {


	public List<Enquete> recupera() throws Exception {
		String sql = "select id, nome, descricao, criador, datacriacao from tb_enquete order by datacriacao";
		List<Enquete> retorno = new ArrayList<>();

		try(Connection con = new Conexao().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enquete enq = new Enquete();
				enq.setId(rs.getLong("id"));
				enq.setNome(rs.getString("nome"));
				enq.setDescricao(rs.getString("descricao"));
				enq.setCriador(rs.getString("criador"));
				enq.setDataCriacao(rs.getDate("datacriacao").toLocalDate());

				retorno.add(enq);			
			}
			return retorno;			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void altera(Enquete enq) throws Exception {
		String upd = "update tb_enquete set nome=?, descricao=?, criador=?, datacriacao=? where id=?";
		try(Connection con = new Conexao().getConexao();
				PreparedStatement pstmt = con.prepareStatement(upd);) {


			pstmt.setString(1, enq.getNome());
			pstmt.setString(2, enq.getDescricao());
			pstmt.setString(3, enq.getCriador());
			pstmt.setDate(4, Date.valueOf(enq.getDataCriacao()));
			pstmt.setLong(5, enq.getId());

			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	public void deleta(long id) throws Exception {
		String del = "delete from tb_enquete where id = ?";
		try(Connection con = new Conexao().getConexao();
				PreparedStatement pstmt = con.prepareStatement(del);) {

			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void insere(Enquete enq) throws Exception {
		String ins = "insert into tb_enquete(nome, descricao, criador, datacriacao) "
				+ "values(?, ?, ? ,?)";
				
		try(Connection con = new Conexao().getConexao();
			PreparedStatement pstmt = con.prepareStatement(ins, new String[] {"id"});) {

			pstmt.setString(1, enq.getNome());
			pstmt.setString(2, enq.getDescricao());
			pstmt.setString(3, enq.getCriador());
			pstmt.setDate(4, Date.valueOf(enq.getDataCriacao()));
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enq.setId(rs.getLong(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}








