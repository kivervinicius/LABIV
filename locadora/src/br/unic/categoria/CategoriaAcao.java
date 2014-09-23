package br.unic.categoria;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class CategoriaAcao {

	private List<Categoria> categorias;
	
	private DataModel<Categoria> categoriasDM;
	
	private CategoriaNegocio categoriaNegocio;
	
	/* Bean/Pojo */
	private Categoria categoria;
	
	public CategoriaAcao() {
		this.categoria = new Categoria();
		this.categorias = new ArrayList<Categoria>();
		this.categoriaNegocio = new CategoriaNegocio();
	}
	
	public List<Categoria> listar(){
		this.categorias = this.categoriaNegocio.listaTudo();
		return this.categorias;
	}
	
	public String cadastrar(){
		//this.categorias.add(this.categoria);
		this.categoriaNegocio.inserir(this.categoria);
		return "listar";
	}
	
	public String alterar(){
		/*Integer localizacao = this.categorias.indexOf(this.categoria);
		this.categorias.set(localizacao, this.categoria);*/
		//this.categorias[localizacao] = this.categoria;
		this.categoriaNegocio.atualizar(this.categoria);
		return "listar";
	}
	
	public String remover(){
		this.categoria = this.categoriasDM.getRowData();
		//this.categorias.remove(this.categoria);
		this.categoriaNegocio.remover(this.categoria);
		return "listar";
	}
	
	public String exibirFormulario(){
		this.categoria = new Categoria();
		return "exibirFormulario";
	}
	
	public String exibirFormularioEditar(){
		this.categoria = categoriasDM.getRowData();
		return "exibirFormulario";
	}
	
	
	
	
	/* GETTER AND SETTERS */

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public DataModel<Categoria> getCategoriasDM() {
		this.listar();
		categoriasDM = new ListDataModel<Categoria>(categorias);
		return categoriasDM;
	}


	public void setCategoriasDM(DataModel<Categoria> categoriasDM) {
		this.categoriasDM = categoriasDM;
	}
	
}
