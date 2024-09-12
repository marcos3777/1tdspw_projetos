import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private String telefone;
	private String email;
	private LocalDate nascimento;
	
	private String apelido;
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public static void main(String args[]) {
		try {
			FileOutputStream fos = new FileOutputStream("/Users/eduardogondo/pessoas.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			List<Pessoa> cadastro = new ArrayList<>();
			
			Pessoa p = new Pessoa();
			p.setNome("Eduardo");
			p.setEmail("profeduardo@fiap.com.br");
			p.setId(1);
			p.setTelefone("(11) 837423093");
			p.setNascimento(LocalDate.of(2000, 5, 5));
			cadastro.add(p);
			
			p = new Pessoa();
			p.setNome("Rafael");
			p.setEmail("ronqui@fiap.com.br");
			p.setId(2);
			p.setTelefone("(11) 93845093");
			p.setNascimento(LocalDate.of(2001, 8, 15));
			cadastro.add(p);
			
			oos.writeObject(cadastro);
			oos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", nascimento="
				+ nascimento + "]";
	}
	
}
