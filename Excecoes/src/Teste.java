import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.print("Informe o salario: ");
		
		try {
			double salario = tec.nextDouble();
			System.out.println("Salario " + salario);
		
			String nome = "Olimpiadas 2024";
			System.out.println(nome.toUpperCase());
		}
		catch(InputMismatchException ime) {
			System.out.println("Erro na inserção do salário!");
			//ime.printStackTrace();
		}
		catch(NullPointerException npe) {
			System.out.println("Tem algum objeto que esta nulo!");
			//npe.printStackTrace();
		}
		finally {
			System.out.println("Sempre executa independente se houve erro ou não");
			//Quando nosso programa/método utiliza recursos externos ao Java.
			//Por exemplo, banco de dados, arquivos, etc. É importante liberar
			//esses recursos antes do programa finalizar
		}
	}

}
