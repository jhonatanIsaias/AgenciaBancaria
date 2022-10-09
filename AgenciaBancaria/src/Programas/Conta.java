package Programas;

public class Conta {
	private static int contadorDeContas = 1;
	
	private int numConta;
	private Pessoa pessoa;
	private boolean situacaoConta;
	private Double saldo ;
	
	public Conta(Pessoa pessoa) {
		this.situacaoConta = true;
		this.numConta = contadorDeContas;
		this.pessoa = pessoa;
		this.saldo = 0.0;
		contadorDeContas++;
	}
	
	public boolean isSituacaoConta() {
		return situacaoConta;
	}
	public void setSituacaoConta(boolean situacaoConta) {
		this.situacaoConta = situacaoConta;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return  "------------------------------------------ \n"+
				"numero da conta: "+this.getNumConta()+"\n"+
				"Nome do Titular: "+this.getPessoa().getNome()+"\n"+
				"situaão da conta: "+this.isSituacaoConta()+"\n"+
				"E-mail: "+this.getPessoa().getEmail()+"\n"+
				"CPF: "+this.getPessoa().getCpf()+"\n"+
				"Saldo: "+Utilitarios.Utils.doubleToString(this.getSaldo());
		
	}
	public void depositar(double valor) {
		if(valor > 0 && this.situacaoConta) {
			this.setSaldo(this.getSaldo() + valor);
			System.out.println("Deposito Realizado com sucesso");
		}
		else {
			System.out.println("Não foi possivel fazer o deposito");
			
		}
		
	}
	public void sacar(double valor) {
		if(this.getSaldo() > 0 && valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("Saque Realizado com sucesso");

		}
		else {
			System.out.println("Não foi possivel fazer o deposito");
		}
	}
	public void fecharConta() {
		if(this.getSaldo() == 0 && this.isSituacaoConta() == true) {
			this.setSituacaoConta(false);
		
			System.out.println("Conta fechada com sucesso");
		}
		else {
			System.out.println("Não foi possivel fechar a conta");
		}
	}
	public void transferir(Conta contaParaDeposito , double valor) {
		if(contaParaDeposito.isSituacaoConta() == true && valor > 0 && this.getSaldo() >= valor) {
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo()+valor);
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("Transferência realizada com sucesso");
		}
		else {
			System.out.println("Não foi possivel realizar a transferência ");
		}
		
	}
	
}
