
public class ExemploSplit {

	public static void main(String[] args) {
		String s = "2024-08-14;Posto Shell;3420 9829 0923 8272;250.80";
		String[] campos = s.split(";");
		
		System.out.println(campos);
		
		for(String info : campos) {
			System.out.println(info);
		}
		
		for(int i = 0; i < campos.length; i++) {
			System.out.println(campos[i]);
		}
	}
	
}
