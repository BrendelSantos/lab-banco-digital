import java.util.Scanner;

public class AutenticacaoCliente {

    private Scanner scanner;
    private String loginInserido;
    private String senhaInserida;

    public void autenticarCliente(Cliente cliente) {

        while (!cliente.getBlAutenticado()) {

            solicitarCredenciais();
            if (!validarCredenciais(cliente, loginInserido, senhaInserida)) 
                System.out.println("Credenciais inválidas!");

        }

        System.out.println("Cliente " + "\"" + cliente.getNome() + "\"" + " autenticado");

    }

    private void solicitarCredenciais() {

        scanner = new Scanner(System.in);
        System.out.println("Insira o login: ");
        loginInserido = scanner.nextLine();

        System.out.println("Insira a senha: ");
        senhaInserida = scanner.nextLine();

    }

    private boolean validarCredenciais(Cliente cliente, String login, String senha) {

        if (login.equals(cliente.getLogin()) && senha.equals(cliente.getSenha())) {

            cliente.setBlAutenticado(true);
            return true;

        }

        return false;

    }

}
