import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Leitura {

	public static void main(String[] args) throws Exception {
		FileInputStream fos = new FileInputStream("/Users/eduardogondo/pessoas.dat");
		ObjectInputStream oos = new ObjectInputStream(fos);
		List<Pessoa> cadastro = (List<Pessoa>)oos.readObject();
		for(Pessoa p : cadastro) {
			System.out.println(p);
		}
		
		
	}
	
}
