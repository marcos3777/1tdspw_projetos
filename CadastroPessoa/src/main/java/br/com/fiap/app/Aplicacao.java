package br.com.fiap.app;

import br.com.fiap.bo.CadastroBusiness;
import br.com.fiap.model.Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();

        List<Pessoa> lst = null;
        try {
            lst = app.leInfoArquivo("/Users/eduardogondo/dadospessoa.csv");
            CadastroBusiness neg = new CadastroBusiness();
            for(Pessoa p : lst) {
                //System.out.println(p.getNome() + " " + p.getEmail());
                neg.cadastraPessoa(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> leInfoArquivo(String arquivo) throws Exception {
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        List<Pessoa> resp = new ArrayList<>();

        String linha = br.readLine();
        while (linha != null) {
            if (!linha.startsWith("nome;email;sexo;")) {
                //converte a string em um obj Pessoa
                //adiciono este objeto em resp
                Pessoa p = convertePessoa(linha);
                resp.add(p);
            }
            linha = br.readLine();
        }
        br.close();
        fr.close();
        return resp;
    }

    private Pessoa convertePessoa(String linha) {
        Pessoa p = new Pessoa();
        String[] campos = linha.split(";");
        if (campos.length > 0) {
            p.setNome(campos[0]);
            p.setEmail(campos[1]);
            p.setSexo(campos[2]);
            p.setLogradouro(campos[3]);
            String[] aux = campos[4].split(",");
            p.setCidade(aux[0]);
            p.setUf(aux[1]);
        }
        return p;
    }
}
