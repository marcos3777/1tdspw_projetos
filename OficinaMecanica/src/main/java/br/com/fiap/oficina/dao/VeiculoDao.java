package br.com.fiap.oficina.dao;

import br.com.fiap.oficina.dto.VeiculoDTO;
import br.com.fiap.oficina.model.OrdemServico;
import br.com.fiap.oficina.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {

    public void insere(Veiculo v) throws Exception {
        String ins = "INSERT into t_veiculo(placa, modelo, marca, dono, ano) " +
                "values(?, ?, ? ,?, ?)";
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(ins, new String[]{"id"});) {

            pstmt.setString(1, v.getPlaca());
            pstmt.setString(2, v.getModelo());
            pstmt.setString(3, v.getMarca());
            pstmt.setString(4, v.getDono());
            pstmt.setInt(5, v.getAno());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                v.setId(rs.getBigDecimal(1).longValue());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public VeiculoDTO recuperaVeiculoDTO(long id) throws Exception {
        String sql = "select v.id, v.dono, v.modelo, v.marca, v.placa, v.ano, " +
                "os.id as id_os, os.data, os.descricao, os.mecanico, os.valor " +
                "from t_veiculo v inner join t_ordemservico os on v.id=os.veiculo_id " +
                "where v.id=? order by os.data desc";
        VeiculoDTO veiculo = new VeiculoDTO();
        try(Connection con = new Conexao().getConexao();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            List<OrdemServico> oss = new ArrayList<>();

            while (rs.next()) {
                long idVeiculo = rs.getLong("id");
                String dono = rs.getString("dono");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");

                long idOs = rs.getLong("id_os");
                LocalDate data = rs.getDate("data").toLocalDate();
                String desc = rs.getString("descricao");
                String mec = rs.getString("mecanico");
                double valor = rs.getDouble("valor");

                veiculo.setAno(ano);
                veiculo.setDono(dono);
                veiculo.setId(idVeiculo);
                veiculo.setModelo(modelo);
                veiculo.setMarca(marca);
                veiculo.setPlaca(placa);

                OrdemServico os = new OrdemServico();
                os.setId(idOs);
                os.setData(data);
                os.setDescricao(desc);
                os.setMecanico(mec);
                os.setValor(valor);

                oss.add(os);
            }
            veiculo.setOrdensServico(oss);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return veiculo;
    }
}
