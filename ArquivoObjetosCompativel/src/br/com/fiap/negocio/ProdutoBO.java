package br.com.fiap.negocio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Produto;
import br.com.fiap.model.Registro;

public class ProdutoBO {
	
	
	public void gravaListaRegistros(List<Registro> registros) throws Exception {
		FileOutputStream fos = new FileOutputStream("d:/registros.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(registros);
		oos.close();
	}

	
	public void gravaProduto(Produto p) throws Exception {
		
		//FileOutputStream fos = new FileOutputStream("c:/arquivos/produto.dat");
		FileOutputStream fos = new FileOutputStream("d:/produto.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p);
		fos.close();
		oos.close();
	}

	public Produto leProduto() throws Exception {
		FileInputStream fis = new FileInputStream("d:/produto.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Produto p = (Produto)ois.readObject();
		fis.close();
		ois.close();
		return p;
	}
	
	public List<Registro> leArquivoPrecos(String arquivo) throws Exception {
		List<Registro> retorno = new ArrayList<>();
		
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);

		String linha = br.readLine();
		while (linha != null) {
			Registro reg = processaLinha(linha);
			if (reg != null) {
				retorno.add(reg);
			}
			linha = br.readLine();
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param linha do arquivo que representa um registro
	 * @return a linha convertida para o objeto registro, se registro 
	 * não existe eu retorno null
	 */
	private Registro processaLinha(String linha) {
		if (linha.startsWith("Local;Estabelecimento;Produto")) {
			return null;
		}
		String[] campos = linha.split(";");
		Registro reg = new Registro();
		reg.setLocal(campos[0]);
		reg.setEstabelecimento(campos[1]);
		reg.setProduto(campos[2]);
		if (campos.length <= 3)
			return null;
		double preco = Double.parseDouble(campos[3].replace(',', '.'));
		reg.setPreco(preco);
		return reg;
	}

	public static void main(String[] args) {
		Produto prod = new Produto();
		prod.setNome("Pasta de dente");
		prod.setClassificacao("Higiene Pessoal");
		prod.setQuantidade(2000);
		prod.setPreco(5.89);
		
		ProdutoBO negocio = new ProdutoBO();
		
		try {
			//negocio.gravaProduto(prod);
			Produto p = negocio.leProduto();
			System.out.println("Produto " + p.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
