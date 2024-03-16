package br.com.projetoMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoMVC.model.Produto;
import br.com.projetoMVC.util.ConnectionFactory;

public class ProdutoDAOImpl implements GenericDAO {
	
	private Connection conn;
	
	// Construtor vazio da calsse ProdutoDAOImpl, iniciando a conexão com o 
	// banco de dados através da classe ConnectionFactory
	public ProdutoDAOImpl () throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			System.out.println("ProdutoDAOImpl: Conectado com sucesso!");
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Object> listarTodos() {
		
		List<Object> lista = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUTO";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				lista.add(produto);
			}
		} catch(SQLException ex) {
			System.out.println("Problema na DAO ao listar Produto! " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch(Exception ex) {
				System.out.println("Problema na DAO ao fechar conexão! " + ex.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public Object listaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
