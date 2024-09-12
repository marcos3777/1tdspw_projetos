import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TesteIO {

	public static void main(String[] args) {

		File f = new File("/tmp/dados.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Ola Mundo! Bem-vindo às Olímpiadas de 2024");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
