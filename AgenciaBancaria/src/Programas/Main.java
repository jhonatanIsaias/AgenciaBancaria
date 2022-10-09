package Programas;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	static ArrayList<Conta> contasBancarias = new ArrayList<Conta>();
	
	public static void main(String[] args) {
		operacoes();
	}
	public static void operacoes() {
		
		Scanner ler = new Scanner(System.in);

		System.out.println("------------------------------------------------");
		System.out.println("-------------Bem vindos a Nossa Agência---------");
		System.out.println("------------------------------------------------");
		System.out.println("***Selecione Uma operação que deseja utilizar***");
		System.out.println("------------------------------------------------");
		System.out.println("|     Opção 1 - Criar Conta     |");
		System.out.println("|     Opção 2 - Depositar       |");
		System.out.println("|     Opção 3 - Sacar           |");
		System.out.println("|     Opção 4 - Transferir      |");
		System.out.println("|     Opção 5 - Listar          |");
		System.out.println("|     Opção 6 - Fechar Conta    |");
		System.out.println("|     Opção 7 - Sair            |");
		
		int opcao = ler.nextInt();
		
		switch(opcao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3: 
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6: 
			fecharConta();
			break;
		case 7: 
			System.out.println("Obrigado e Volte Sempre");
			System.exit(0);
		
		default: System.out.println("Opção Inválida");
			operacoes();
			break;
		}
	}
	public static void criarConta() {
		Scanner ler = new Scanner(System.in);

		System.out.println("nome: ");
		String nome = ler.nextLine();
		
		System.out.println("CPF: ");
		String CPF = ler.nextLine();
		
		System.out.println("E-mail: ");
		String Email = ler.nextLine();
		
		Pessoa pessoa = new Pessoa(nome,CPF,Email);
		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso");
		
		operacoes();
	}
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumConta() == numeroConta) {
					conta =c;
				}
			}
		}
		return conta;
	}
	public static void depositar() {
		Scanner ler = new Scanner(System.in);


		System.out.println("Digite o numero da sua conta: ");
		int numConta = ler.nextInt();
		Conta conta = encontrarConta(numConta);
		
		if(conta !=null && conta.isSituacaoConta()!= false) {
			System.out.println("digite o valor que deseja depositar: ");
			double valor = ler.nextDouble();
			
			conta.depositar(valor);
			System.out.println("Valor despositado com sucesso");
		}
		else {
			System.out.println("Sua conta não foi encontrada");
		}
		operacoes();
	}
	public static void sacar() {
		Scanner ler = new Scanner(System.in);


		System.out.println("Digite o numero da sua conta: ");
		int numConta = ler.nextInt();
		Conta conta = encontrarConta(numConta);
		
		if(conta !=null && conta.isSituacaoConta()!= false) {
			System.out.println("digite o valor que deseja sacar: ");
			double valor = ler.nextDouble();
			
			conta.sacar(valor);
			System.out.println("Valor sacado com sucesso");
		}
		else {
			System.out.println("Sua conta não foi encontrada");
		}
		operacoes();
	}
	public static void transferir() {
		Scanner ler = new Scanner(System.in);

		System.out.println("digite o numero da conta do remetente: ");
		int numeroContaRemetente = ler.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		
		
		if(contaRemetente != null && contaRemetente.isSituacaoConta()!= false) {
			System.out.println("Digite o numero da conta do Destinatario: ");
			int numeroContaDestinatario = ler.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			if(contaDestinatario != null && contaDestinatario.isSituacaoConta()!= false) {
				System.out.println("digite o valor que deseja transferir: ");
				double valor = ler.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}
			else {
				System.out.println("Não encotramos a conta do Destinatario");
			}

		}
		else {
			System.out.println("Não encotramos sua conta");
		}

		operacoes();
	}
	public static void fecharConta() {
		Scanner ler = new Scanner(System.in);

		System.out.println("Digite o numero da sua conta: ");
		int numeroConta = ler.nextInt();
		
		Conta contaFechar = encontrarConta(numeroConta);
		
		if(contaFechar != null) {
			contaFechar.fecharConta();
			
		}
		else {
			System.out.println("Não encontramos sua conta");
		}
		operacoes();
	}
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				System.out.println(c);
			}
		}
		else {
			System.out.println("Ainda não existe contas cadastradas");
		}
		operacoes();
	}
	
}
