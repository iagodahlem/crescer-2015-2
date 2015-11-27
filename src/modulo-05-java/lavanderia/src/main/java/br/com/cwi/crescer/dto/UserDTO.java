package br.com.cwi.crescer.dto;

public class UserDTO {

	private String nome;
	private String password;
	private String flag;
	
	public UserDTO(String user, String flag) {
		this.nome = user;
		this.flag = flag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
