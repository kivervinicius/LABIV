package br.unic.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioController {
	
	public UsuarioController() {
		this.usuario = new Usuario();
	}

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void executar(){
		System.out.println(usuario.getNome());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getCargo());
		for (String idioma : usuario.getIdiomas()) {
			System.out.println(idioma);
		}
		
	}
	
}
