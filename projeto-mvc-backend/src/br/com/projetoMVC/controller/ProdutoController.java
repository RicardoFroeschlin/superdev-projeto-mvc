package br.com.projetoMVC.controller;

import java.util.ArrayList;
import java.util.List;
import br.com.projetoMVC.DAO.GenericDAO;
import br.com.projetoMVC.DAO.ProdutoDAOImpl;
import br.com.projetoMVC.model.Produto;

public class ProdutoController {
	
	public List<Produto> listarTodos() {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			List<Produto> lista =  new ArrayList<Produto>();
			
			for (Object object : dao.listarTodos()) {
				lista.add( (Produto) object );
			}
			return lista;
			
		} catch(Exception ex) {
			System.out.println("Problemas na Controller para listar Produtos" + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public boolean cadastrar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.cadastrar(produto);
			return true;
		} catch (Exception ex) {
			System.out.println("Problemas na controller para cadastrar Produto" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public boolean alterar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.alterar(produto);
			return true;
		}catch (Exception ex) {
			System.out.println("Problemas na Controller para alterar Produto" + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}
	
	public Produto listarPorId(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			Produto produto = (Produto) dao.listaPorId(id);
			return produto;
		} catch (Exception ex) {
			System.out.println("Problemas na Controller para listar Produtos " + ex.getMessage());
			ex.printStackTrace();
			return null,
		}
	}
	
	public void excluir(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.excluir(id);
		} catch (Exception ex) {
			System.out.println("Problemas na Controller para excluir Produto" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
