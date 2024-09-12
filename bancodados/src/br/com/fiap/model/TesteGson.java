package br.com.fiap.model;

import com.google.gson.Gson;

public class TesteGson {

	public static void main(String[] args) {
		
		Endereco end = new Endereco();
		end.setBairro("Jardins");
		end.setLogradouro("Av Paulista");
		end.setNumero("1400");
		
		Pessoa p = new Pessoa();
		p.setNome("Eduardo");
		p.setCpf("224.385.982-90");
		p.setEndereco(end);
		
		Gson json = new Gson();
		String s = json.toJson(p);
		System.out.println(s);
		
		
	}
	
	
}
