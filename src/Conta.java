
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public boolean sacar(double valor) {
 
		if (valor > saldo) {

			System.out.println("O valor informado é maior que o saldo da conta");
			return false;

		} else if (valor <= 0) {

			System.out.println("O valor informado deve ser maior que zero");
			return false;

		} else {

			saldo -= valor;
			return true;
		}

	}

	@Override
	public void depositar(double valor) {

		if (valor <= 0)
			System.out.println("O valor informado deve ser maior que zero");
		else 
			saldo += valor;

	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		
		if (this.sacar(valor))
			contaDestino.depositar(valor);
			
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
