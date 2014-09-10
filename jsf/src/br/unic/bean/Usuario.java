package br.unic.bean;

public class Usuario {
	private String nome;
	private String cargo;
	private String cpf;
	private String[] idiomas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String[] getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String[] idiomas) {
		this.idiomas = idiomas;
	}
}
