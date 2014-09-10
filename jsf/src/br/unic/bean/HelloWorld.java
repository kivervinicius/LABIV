package br.unic.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorld {
	private String nome = "Unic";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
