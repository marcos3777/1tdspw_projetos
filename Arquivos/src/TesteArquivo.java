import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TesteArquivo {
	
	public static void main(String args[]) {
		
		FileReader arq = null;
		try {
			arq = new FileReader("/Users/eduardogondo/dom.sql");
			BufferedReader br = new BufferedReader(arq);
			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//"c:/Users/eduardogondo/<nome_arquivo>"
		
		
	}
}
