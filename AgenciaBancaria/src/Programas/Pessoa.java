package Programas;

public class Pessoa {
	//Atributos
	private static int counter = 1;
	
	private String nome;
	private String cpf;
	private String email;
	

	public Pessoa(String nome, String CPF, String email) {
		this.nome = nome;
		this.cpf = CPF;
		this.email = email;
		
		counter++;
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "nome: "+this.getNome()+"\n"+
				"CPF: "+this.getCpf()+"\n"+
				"E-mail: "+this.getEmail();
	
	}


	
	
}
