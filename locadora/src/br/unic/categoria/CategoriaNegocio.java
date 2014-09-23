package br.unic.categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unic.generic.Conexao;

public class CategoriaNegocio {

	private Conexao conexao;
	private Statement stmt;
	
	public List<Categoria> listaTudo() {
		conexao = new Conexao();
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			stmt = (Statement) conexao.getConn().createStatement();
			String sql = "SELECT * FROM categoria";

			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("CATEGORIA_ID"));
				categoria.setNome(rs.getString("CATEGORIA_NOME"));
				categorias.add(categoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return categorias;
	}
	
	public void inserir(Categoria categoria){
		conexao = new Conexao();
		try {
			String sql = "INSERT INTO categoria (CATEGORIA_NOME) values (?)";
			PreparedStatement preparedStatement = conexao.getConn().prepareStatement(sql);
			preparedStatement.setString(1, categoria.getNome());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		
	}
	
	public void atualizar(Categoria categoria){
		conexao = new Conexao();
		try{
			String sql = "UPDATE categoria set CATEGORIA_NOME = ? where CATEGORIA_ID = ?";
			PreparedStatement preparedStatement = conexao.getConn().prepareStatement(sql);
			preparedStatement.setString(1, categoria.getNome());
			preparedStatement.setInt(2, categoria.getId());
			preparedStatement.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			conexao.fecharConexao();
		}
	}
	
	public void remover(Categoria categoria){
		conexao = new Conexao();
		try{
			String sql = "delete from categoria where CATEGORIA_ID = ?";
			PreparedStatement preparedStatement = conexao.getConn().prepareStatement(sql);
			preparedStatement.setInt(1, categoria.getId());
			preparedStatement.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			conexao.fecharConexao();
		}
	}

}
