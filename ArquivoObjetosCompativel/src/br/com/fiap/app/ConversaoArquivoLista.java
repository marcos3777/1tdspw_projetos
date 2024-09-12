package br.com.fiap.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.model.Registro;
import br.com.fiap.negocio.ProdutoBO;

public class ConversaoArquivoLista {

	public static void main(String[] args) {
		
		ProdutoBO neg = new ProdutoBO();
		String arq = "d:/precos.csv";
		try {
			List<Registro> lista = neg.leArquivoPrecos(arq);
//			for(Registro reg : lista) {
//				System.out.println(reg.getLocal() + " " + reg.getProduto());
//			}
			
			//criando objeto Map
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(Registro reg : lista) {
				if (map.containsKey(reg.getProduto())) {
					int num = map.get(reg.getProduto());
					num++;
					map.put(reg.getProduto(), num);
				}
				else {
					map.put(reg.getProduto(), 1);
				}
			}
			for(String key : map.keySet()) {
				System.out.println(key + "=>" + map.get(key));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
