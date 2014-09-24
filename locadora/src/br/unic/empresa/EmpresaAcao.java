package br.unic.empresa;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class EmpresaAcao {
	
	private List<Empresa> empresas;
	
	private DataModel<Empresa> empresasDM;
	
	private EmpresaNegocio empresaNegocio;
	
	private Empresa empresa;
	
	public EmpresaAcao() {
		this.empresas = new ArrayList<Empresa>();
		this.empresaNegocio = new EmpresaNegocio();
		this.empresa = new Empresa();
	}
	
	public List<Empresa> listar(){
		this.empresas = this.empresaNegocio.listaTudo();
		return this.empresas;
	}
	
	public String cadastrar(){
		this.empresaNegocio.inserir(this.empresa);
		return "listar";
	}
	
	public String alterar(){
		this.empresaNegocio.atualizar(this.empresa);
		return "listar";
	}
	
	public String remover(){
		this.empresa = this.empresasDM.getRowData();
		this.empresaNegocio.remover(this.empresa);
		return "listar";
	}
	
	public String exibirFormulario(){
		this.empresa = new Empresa();
		return "exibirFormulario";
	}
	
	public String exibirFormularioAlterar(){
		this.empresa = this.empresasDM.getRowData();
		return "exibirFormulario";
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public DataModel<Empresa> getEmpresasDM() {
		this.listar();
		empresasDM = new ListDataModel<Empresa>(this.empresas);
		return empresasDM;
	}

	public void setEmpresasDM(DataModel<Empresa> empresasDM) {
		this.empresasDM = empresasDM;
	}

	public EmpresaNegocio getEmpresaNegocio() {
		return empresaNegocio;
	}

	public void setEmpresaNegocio(EmpresaNegocio empresaNegocio) {
		this.empresaNegocio = empresaNegocio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
}
