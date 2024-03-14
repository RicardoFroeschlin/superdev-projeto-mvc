package br.com.projetoMVC.DAO;

import java.util.List;

public interface GenericDAO {
	
	public List<Object> listarTodos();
	
	public Object listaPorId(int id);
	public boolean cadastrar(Object object);
	
	public boolean alterar(Object object);
	
	public void excluir(int id);

}
