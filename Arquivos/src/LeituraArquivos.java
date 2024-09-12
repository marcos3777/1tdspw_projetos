import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivos {

	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader("/Users/eduardogondo/exemplo.c");
			BufferedReader br = new BufferedReader(fr);) {
			
			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
