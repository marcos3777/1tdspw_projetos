package br.com.fiap.oficina.negocio;

import br.com.fiap.oficina.dao.OrdemServicoDao;
import br.com.fiap.oficina.dao.VeiculoDao;
import br.com.fiap.oficina.dto.VeiculoDTO;
import br.com.fiap.oficina.model.OrdemServico;
import br.com.fiap.oficina.model.Veiculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.List;

public class OrdemServicoBusiness {

    public void cadastra(OrdemServico os) throws Exception {
        //se o veiculo da ordem de servico existe entao
        //   cadastro a ordem de servico associado ao veiculo
        //senao
        //   cadastro o veiculo e depois cadastro a ordem de servico

        VeiculoDao vdao = new VeiculoDao();
        vdao.insere(os.getVeiculo());
        OrdemServicoDao odao = new OrdemServicoDao();
        odao.insere(os);
    }

    public VeiculoDTO recuperaVeiculoComOrdensServico(long id) throws Exception {
        VeiculoDao vdao = new VeiculoDao();
        return vdao.recuperaVeiculoDTO(id);
    }


    public static void main(String[] args) throws Exception {
       /* OrdemServicoBusiness neg = new OrdemServicoBusiness();
        Veiculo v = new Veiculo();
        v.setPlaca("ABC-8749");
        v.setAno(2020);
        v.setMarca("Ford");
        v.setModelo("Fiesta");
        v.setDono("Eduardo");

        OrdemServico os = new OrdemServico();
        os.setMecanico("Joaquim");
        os.setData(LocalDate.now());
        os.setVeiculo(v);
        neg.cadastra(os);*/

        VeiculoDao vdao = new VeiculoDao();
        VeiculoDTO veiculo = vdao.recuperaVeiculoDTO(2);
        System.out.println(veiculo.getPlaca() + " - " + veiculo.getModelo());
        for(OrdemServico os : veiculo.getOrdensServico()) {
            System.out.println(os.getData() + " " + os.getDescricao() + " " +
                                    os.getMecanico() + " " + os.getValor());
        }


        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        Gson gson = builder.create();
        String json = gson.toJson(veiculo);
        System.out.println(json);

    }
}
