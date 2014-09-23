package br.unic.empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import br.unic.categoria.Categoria;
import br.unic.generic.Conexao;
import br.unic.generic.INegocio;

public class EmpresaNegocio implements INegocio<Empresa>{
	
	private Conexao conexao;
	
	public List<Empresa> listaTudo() {
		Statement stmt = null;
		this.conexao = new Conexao();
		List<Empresa> retorno = new ArrayList<Empresa>();
		try {
			stmt = (Statement) conexao.getConn().createStatement();
			String sql = "SELECT * FROM empresa";

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setId(rs.getInt("EMPRESA_ID"));
				empresa.setNome(rs.getString("EMPRESA_NOME"));
				empresa.setEmail(rs.getString("EMPRESA_EMAIL"));
				empresa.setEndereco(rs.getString("EMPRESA_ENDERECO"));
				empresa.setSite(rs.getString("EMPRESA_SITE"));
				empresa.setTelefone(rs.getString("EMPRESA_TELEFONE"));
				empresa.setCnpj(rs.getString("EMPRESA_CNPJ"));
				retorno.add(empresa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			this.conexao.fecharConexao();
		}
		return retorno;
	}

	public void inserir(Empresa empresa) {
		this.conexao = new Conexao();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO empresa ");
			sql.append("(");
			sql.append(" EMPRESA_NOME, ");
			sql.append(" EMPRESA_EMAIL, ");
			sql.append(" EMPRESA_ENDERECO, ");
			sql.append(" EMPRESA_SITE, ");
			sql.append(" EMPRESA_TELEFONE, ");
			sql.append(" EMPRESA_CNPJ ");
			sql.append(") VALUES (");
			sql.append(" ?,?,?,?,?,?");
			sql.append(");");
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sql.toString());
			pStmt.setString(1, empresa.getNome());
			pStmt.setString(2, empresa.getEmail());
			pStmt.setString(3, empresa.getEndereco());
			pStmt.setString(4, empresa.getSite());
			pStmt.setString(5, empresa.getTelefone());
			pStmt.setString(6, empresa.getCnpj());
			pStmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.conexao.fecharConexao();
		}
	}

	public void atualizar(Empresa empresa) {
		this.conexao = new Conexao();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE empresa SET ");
			sql.append(" EMPRESA_NOME=?, ");
			sql.append(" EMPRESA_EMAIL=?, ");
			sql.append(" EMPRESA_ENDERECO=?, ");
			sql.append(" EMPRESA_SITE=?, ");
			sql.append(" EMPRESA_TELEFONE=?, ");
			sql.append(" EMPRESA_CNPJ=? ");
			sql.append(" WHERE ");
			sql.append(" EMPRESA_ID=? ");
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sql.toString());
			pStmt.setString(1, empresa.getNome());
			pStmt.setString(2, empresa.getEmail());
			pStmt.setString(3, empresa.getEndereco());
			pStmt.setString(4, empresa.getSite());
			pStmt.setString(5, empresa.getTelefone());
			pStmt.setString(6, empresa.getCnpj());
			pStmt.setInt(7, empresa.getId());
			pStmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.conexao.fecharConexao();
		}
	}

	public void remover(Empresa empresa) {
		this.conexao = new Conexao();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM empresa ");
			sql.append(" WHERE ");
			sql.append(" EMPRESA_ID=? ");
			
			PreparedStatement pStmt = conexao.getConn().prepareStatement(sql.toString());
			pStmt.setInt(1, empresa.getId());
			pStmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.conexao.fecharConexao();
		}
	}

}
