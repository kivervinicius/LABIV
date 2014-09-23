package br.unic.generic;

import java.util.List;

public interface INegocio<T> {
	
	public List<T> listaTudo();
	
	public void inserir(T objeto);
	
	public void atualizar(T objeto);
	
	public void remover(T objeto);
}
