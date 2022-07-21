
public class Cliente {

	private String nome;
	private String login;
	private String senha;
	private boolean blAutenticado;

	public String getNome() {
		return nome;
	}

	public boolean getBlAutenticado() {
		return blAutenticado;
	}

	public void setBlAutenticado(boolean blAutenticado) {
		this.blAutenticado = blAutenticado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
