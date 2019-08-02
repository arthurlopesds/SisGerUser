package br.com.model;

public class Cliente {

	private String login;
	private String senha;
	private String status;
	
	public Cliente(String login,String senha,String status){
		this.login = login;
		this.senha = senha;
		this.setStatus(status);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cliente : " + getLogin() + "Senha: "+ getSenha();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
	
}
