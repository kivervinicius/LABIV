package br.unic.municipio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MunicipioController {
	
	public MunicipioController() {
		municipio = new Municipio();
		estados = new ArrayList<String>();
		estados.add("Mato Grosso");
		estados.add("São Paulo");
		estados.add("Paraná");
		estados.add("Santa Catarina");
	}
	
	private Municipio municipio;
	
	private List<String> estados;

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public void executar(){
		System.out.println(municipio.getNome());
		System.out.println(municipio.getEstado());
		System.out.println(municipio.getCep());
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	
	
	
	
}
