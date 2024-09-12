package br.com.fiap.bo;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.model.Pessoa;

public class CadastroBusiness {

    public void cadastraPessoa(Pessoa pes) throws Exception {
        PessoaDAO dao = new PessoaDAO();
        dao.insert(pes);
    }
}
