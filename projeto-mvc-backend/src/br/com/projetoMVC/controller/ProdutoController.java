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

}
