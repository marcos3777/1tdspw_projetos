package br.com.fiap.enquete.teste;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.enquete.dao.EnqueteDao;
import br.com.fiap.enquete.model.Enquete;

public class Teste {
	
	public static void main(String[] args) {
		
		Enquete alt = new Enquete();
		alt.setId(1);
		alt.setCriador("Eduardo");
		alt.setNome("Checkpoint 4");
		alt.setDescricao("Primeiro checkpoint do 2 semestre");
		alt.setDataCriacao(LocalDate.of(2024, 12, 9));
		
		EnqueteDao banco = new EnqueteDao();
		try {
			
			Enquete prefeitura = new Enquete();
			prefeitura.setCriador("IBOPE");
			prefeitura.setDescricao("Eleição de prefeito de São Paulo");
			prefeitura.setNome("Pesquisa Eleitoral");
			prefeitura.setDataCriacao(LocalDate.now());
			
			banco.insere(prefeitura);
			
			System.out.println("ID: " + prefeitura.getId());
			
			banco.altera(alt);
			List<Enquete> lista = banco.recupera();
			for(Enquete enq : lista) {
				System.out.println(enq.getNome() + " " + enq.getDescricao());
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
