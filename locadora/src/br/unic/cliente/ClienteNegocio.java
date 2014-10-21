package br.unic.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unic.generic.Conexao;
import br.unic.generic.INegocio;
import br.unic.generic.functions.DataLib;

public class ClienteNegocio implements INegocio<Cliente>{

	private Conexao conexao;
	
	@Override
	public List<Cliente> listaTudo() {
		Statement stmt = null;
		this.conexao = new Conexao();
		List<Cliente> retorno = new ArrayList<Cliente>();
		try {
			stmt = (Statement) conexao.getConn().createStatement();
			String sql = "SELECT * FROM cliente";

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("CLIENTE_ID"));
				cliente.setNome(rs.getString("CLIENTE_NOME"));
				cliente.setRg(rs.getString("CLIENTE_RG"));
				cliente.setCpf(rs.getString("CLIENTE_CPF"));
				cliente.setEmail(rs.getString("CLIENTE_EMAIL"));
				cliente.setEndereco(rs.getString("CLIENTE_ENDERECO"));
				cliente.setEmpresaId(rs.getInt("EMPRESA_ID"));
				cliente.setTelefone(rs.getString("CLIENTE_TELEFONE"));
				cliente.setDataNascimento(
						DataLib.converterDataMysql(
								rs.getString("CLIENTE_DATANASCIMENTO")
						)
				);
				retorno.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public void inserir(Cliente cliente) {
		this.conexao = new Conexao();
		try {
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" INSERT INTO cliente( ");
			sbSql.append("  cliente_nome,");
			sbSql.append("  cliente_rg,");
			sbSql.append("  cliente_email,");
			sbSql.append("  cliente_cpf,");
			sbSql.append("  cliente_endereco,");
			sbSql.append("  cliente_telefone,");
			sbSql.append("  empresa_id, ");
			sbSql.append("  cliente_datanascimento )");
			sbSql.append(" VALUES ");
			sbSql.append(" (");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ?,");
			sbSql.append(" ? )");
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sbSql.toString());
			pStmt.setString(1, cliente.getNome());
			pStmt.setString(2, cliente.getRg());
			pStmt.setString(3, cliente.getEmail());
			pStmt.setString(4, cliente.getCpf());
			pStmt.setString(5, cliente.getEndereco());
			pStmt.setString(6, cliente.getTelefone());
			pStmt.setInt(7, cliente.getEmpresaId());
			pStmt.setString(8, DataLib.formatarMysql(cliente.getDataNascimento()));
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		this.conexao = new Conexao();
		try {
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" UPDATE cliente SET ");
			sbSql.append("  cliente_nome=?,");
			sbSql.append("  cliente_rg=?,");
			sbSql.append("  cliente_email=?,");
			sbSql.append("  cliente_cpf=?,");
			sbSql.append("  cliente_endereco=?,");
			sbSql.append("  cliente_telefone=?,");
			sbSql.append("  empresa_id=?, ");
			sbSql.append("  cliente_datanascimento=?");
			sbSql.append(" WHERE cliente_id = ?");
			
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sbSql.toString());
			pStmt.setString(1, cliente.getNome());
			pStmt.setString(2, cliente.getRg());
			pStmt.setString(3, cliente.getEmail());
			pStmt.setString(4, cliente.getCpf());
			pStmt.setString(5, cliente.getEndereco());
			pStmt.setString(6, cliente.getTelefone());
			pStmt.setInt(7, cliente.getEmpresaId());
			pStmt.setString(8, DataLib.formatarMysql(cliente.getDataNascimento()));
			pStmt.setInt(9, cliente.getId());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Cliente cliente) {
		this.conexao = new Conexao();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM cliente ");
			sql.append(" WHERE ");
			sql.append(" cliente_id=? ");
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sql.toString());
			pStmt.setInt(1, cliente.getId());
			pStmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.conexao.fecharConexao();
		}
		
	}

}
