package br.com.projetoMVC;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		ProdutoController controller = new ProdutoController();
		
		Produto p = new Produto();
		p.setDescricao("Mouse");
		controller.cadastrar(p);
		
		System.out.println("- Lista de Produtos - ");
		for (Produto produto : controller.listarTodos()) {
			System.out.println(produto.getDescricao());
		}

	}

}
