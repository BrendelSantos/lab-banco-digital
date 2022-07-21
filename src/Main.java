import java.util.Scanner;

public class Main {

	private static void exibeMenu() {

		System.out.println("\nMenu: (selecione um item de 1 a 5)");
		System.out.println(
				"1: Depósito"
						+ "\n2: Saque"
						+ "\n3: Extrato"
						+ "\n4: Transferir entre contas"
						+ "\n5: SAIR");

	}

	private static void exibeTextoSelecaoConta() {

		System.out.println("Por favor, informe a conta: ");
		System.out.println(
				"1: Conta-corrente"
						+ "\n2: Conta-poupança");

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int itemSelecionado = 0;
		int contaSelecionada = 0;

		AutenticacaoCliente autenticacaoCliente = new AutenticacaoCliente();

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente Teste");
		cliente.setLogin("login");
		cliente.setSenha("senha");

		autenticacaoCliente.autenticarCliente(cliente);

		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaPoupanca(cliente);

		while (cliente.getBlAutenticado()) {

			exibeMenu();

			itemSelecionado = scanner.nextInt();

			if (itemSelecionado > 0 && itemSelecionado <= 4) {

				exibeTextoSelecaoConta();
				contaSelecionada = scanner.nextInt();

			}

			switch (itemSelecionado) {

				case 1:

					deposito(scanner, contaSelecionada, contaCorrente, contaPoupanca);
					break;

				case 2:

					saque(scanner, contaSelecionada, contaCorrente, contaPoupanca);
					break;

				case 3:

					extratoConta(contaSelecionada, contaCorrente, contaPoupanca);
					break;

				case 4:

					transferir(scanner, contaSelecionada, contaCorrente, contaPoupanca);
					break;

				case 5:

					System.out.println("Encerrando o programa...");
					System.exit(0);
					break;

				default:

					System.out.println("Opção inválida. Por favor, insira um número entre 1 e 5");
					break;

			}

		}

	}

	private static void deposito(Scanner scanner, int contaSelecionada, Conta contaCorrente, Conta contaPoupanca) {

		System.out.println("Por favor, informe o valor do depósito: ");
		double valorDeposito = scanner.nextDouble();

		if (contaSelecionada == 1)
			contaCorrente.depositar(valorDeposito);
		else if (contaSelecionada == 2)
			contaPoupanca.depositar(valorDeposito);

	}

	private static void saque(Scanner scanner, int contaSelecionada, Conta contaCorrente, Conta contaPoupanca) {

		System.out.println("Por favor, informe o valor do saque: ");
		double valorSaque = scanner.nextDouble();

		if (contaSelecionada == 1)
			contaCorrente.sacar(valorSaque);
		else if (contaSelecionada == 2)
			contaPoupanca.sacar(valorSaque);

	}

	private static void extratoConta(int contaSelecionada, Conta contaCorrente, Conta contaPoupanca) {

		if (contaSelecionada == 1)
			contaCorrente.imprimirExtrato();
		else if (contaSelecionada == 2)
			contaPoupanca.imprimirExtrato();

	}

	private static void transferir(Scanner scanner, int contaSelecionada, Conta contaCorrente, Conta contaPoupanca) {

		System.out.println("Por favor, informe o valor que será transferido: ");
		double valorTransferencia = scanner.nextDouble();

		if (contaSelecionada == 1) {

			System.out.println("A transferência realizada da conta-corrente para a conta-poupança");
			contaCorrente.transferir(valorTransferencia, contaPoupanca);

		} else if (contaSelecionada == 2) {

			System.out.println("A transferência realizada da conta-poupança para a conta-corrente");
			contaPoupanca.transferir(valorTransferencia, contaCorrente);

		}

	}

}
