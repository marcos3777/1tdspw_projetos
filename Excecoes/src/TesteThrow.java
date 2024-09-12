
public class TesteThrow {

	public static int divisao(int x, int y) throws ArithmeticException {
		if (y == 0) {
			throw new ArithmeticException("Divisão por 0");
		}
		return x / y;
	}
	
	public static void main(String[] args) {
		int a = 2;
		int b = 0;
		
		int resultado;
		try {
			resultado = divisao(a, b);
			System.out.println(resultado);

		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
				
				
	}
	
	
}
