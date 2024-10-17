package br.com.fiap.oficina.dao;

import br.com.fiap.oficina.model.OrdemServico;
import br.com.fiap.oficina.model.Veiculo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class OrdemServicoDao {

    public void insere(OrdemServico os) throws Exception {
        String ins = "INSERT into t_ordemservico(descricao, mecanico, valor, data, veiculo_id) " +
                "values(?, ?, ? ,?, ?)";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(ins);) {

            pstmt.setString(1, os.getDescricao());
            pstmt.setString(2, os.getMecanico());
            pstmt.setDouble(3, os.getValor());
            pstmt.setDate(4, Date.valueOf(os.getData()));
            pstmt.setLong(5, os.getVeiculo().getId());
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
