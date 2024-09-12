package br.com.fiap.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import br.com.fiap.model.Registro;
import br.com.fiap.negocio.ProdutoBO;

public class Exercicio2 {

	public static void main(String[] args) {
		ProdutoBO neg = new ProdutoBO();
		try {
			List<Registro> registros = neg.leArquivoPrecos("D:/precos.csv");
		
			for(Registro reg: registros) {
				System.out.println(reg.getEstabelecimento() + " " + reg.getPreco());
			}
			
			neg.gravaListaRegistros(registros);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
}
