package br.com.fiap.model;

import java.io.Serializable;

public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String local;
	
	private String estabelecimento;
	
	private String produto;
	
	private double preco;

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

}
