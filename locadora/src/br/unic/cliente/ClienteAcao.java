package br.unic.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ClienteAcao {
	
	private List<Cliente> clientes;
	
	private DataModel<Cliente> clientesDM;
	
	private ClienteNegocio clienteNegocio;
	
	private Cliente cliente;
	
	public ClienteAcao() {
		this.clientes = new ArrayList<Cliente>();
		this.clienteNegocio = new ClienteNegocio();
		this.cliente = new Cliente();
	}
	
	public List<Cliente> listar(){
		this.clientes = this.clienteNegocio.listaTudo();
		return this.clientes;
	}
	
	public String cadastrar(){
		this.clienteNegocio.inserir(this.cliente);
		return "listar";
	}
	
	public String alterar(){
		this.clienteNegocio.atualizar(this.cliente);
		return "listar";
	}
	
	public String remover(){
		this.clienteNegocio.remover(this.cliente);
		return "listar";
	}
	
	public String exibirFormulario(){
		this.cliente = new Cliente();
		return "exibirFormulario";
	}
	
	public String exibirFormularioAlterar(){
		this.cliente = this.clientesDM.getRowData();
		return "exibirFormulario";
	}

	public DataModel<Cliente> getClientesDM() {
		this.listar();
		clientesDM = new ListDataModel<Cliente>(this.clientes);
		return clientesDM;
	}

	public void setClientesDM(DataModel<Cliente> clientesDM) {
		this.clientesDM = clientesDM;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
