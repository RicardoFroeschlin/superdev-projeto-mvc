package br.com.projetoMVC;

import java.util.Scanner;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ProdutoController controller = new ProdutoController();
		
		int opcao = 0;
		do {
			
			System.out.println("\n\n+-----------------------+");
			System.out.println("      Menu de Opções     ");
			System.out.println("[1] Listar");
			System.out.println("[2] Buscar por id");
			System.out.println("[3] Cadastrar");
			System.out.println("[4] Alterar");
			System.out.println("[5] Excluir");
			System.out.println("[0] Sair");
			System.out.println("+-----------------------+");
			System.out.println("Escolha uma opçao");
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1: 
				System.out.println("- Lista de Produtos - ");
				System.out.println("Id    Descrição");
				for (Produto produto : controller.listarTodos()) {
					System.out.println(produto.getDescricao() + "    " + produto.getDescricao());
				}
				break;
			case 2:
				System.out.println("Qual id deseja buscar o produto?");
				int idBusca = scan.nextInt();
				Produto produtoPorId = controller.listarPorId(idBusca);
				
				if (produtoPorId != null) {
					System.out.println("Produto: " + produtoPorId.getDescricao());
				} else {
					System.out.println("Produto não encontrado para o código " + idBusca);
				}
				break;
			case 3:
				System.out.println("Qual produto deseja cadastrar?");
				Produto produtoNovo = new Produto();
				produtoNovo.setDescricao(scan.next());
				controller.cadastrar(produtoNovo);
				break;
			case 4:
				System.out.println("Qual id do produto a ser alterado? ");
				int idAlterar = scan.nextInt();

				Produto produtoAlterar = controller.listarPorId(idAlterar);

				if (produtoAlterar != null) {
					System.out.println("Qual a nova descrição para o produto? ");
					produtoAlterar.setDescricao(scan.next());
					controller.alterar(produtoAlterar);
				} else {
					System.out.println("Produto não encontrado para o código " + produtoAlterar);
				}
				break;
			case 5: 
				System.out.println("Qual id do produto a ser excluído? ");
				int idExclusao = scan.nextInt();
				controller.excluir(idExclusao);
				break;
			case 0:
				System.out.println("Saindo do sistema...");
				break;
			
			default:
				System.out.println("Opção inválida!");
				break;
			}
			
		} while (opcao != 0);
		
		scan.close();

		
	}

}
