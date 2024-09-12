import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
	
	public List<Paciente> lePaciente(String arquivo) throws Exception {
		
		List<Paciente> lista = new ArrayList<>();
		
		try(FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);) {
			
			String linha = br.readLine();
			while (linha != null) {
				//System.out.println(linha);
				Paciente p = processa(linha);
				if (p != null)
					lista.add(p);
				
				linha = br.readLine();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return lista;
	}
	
	
	private Paciente processa(String linha) {
		if (linha.startsWith("nome"))
			return null;
		String[] campos = linha.split(";");
		Paciente p = new Paciente();
		p.setNome(campos[0]);
		try {
			p.setNascimento(LocalDate.parse(campos[1]));
		}
		catch (Exception e) {
			p.setNascimento(LocalDate.parse("1900-01-01"));
		}
		p.setPeso(Integer.parseInt(campos[2]));
		p.setAltura(Integer.parseInt(campos[3]));
		p.setSexo(campos[4]);
		p.setTemperatura(Double.parseDouble(campos[5]));
		p.setSintomas(campos[6]);
		return p;
	}


	public static void main(String[] args) {
		PacienteDAO pdao = new PacienteDAO();
		try {
			pdao.lePaciente("d:/pacientes.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

}
