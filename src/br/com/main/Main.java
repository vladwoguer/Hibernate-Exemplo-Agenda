package br.com.main;

import java.util.Scanner;

import br.com.bean.Contato;

/**
 * Interface de texto.
 * 
 * @author Vladwoguer Bezerra
 *
 */
public class Main {
	private static AgendaContatos agenda = new AgendaContatos();
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 3;
		do {
			mostraMenu();
			opcao = Integer.parseInt(teclado.nextLine());
			processaPedido(opcao);
		} while (opcao != 3);
	}

	private static void processaPedido(int opcao) {
		switch (opcao) {
		case 1: {
			System.out.println("Digite o nome do novo contato: ");
			String nome = teclado.nextLine();
			System.out.println("Digite o telefone do novo contato: ");
			String telefone = teclado.nextLine();
			
			if (agenda.salvaNovoContato(nome, telefone)) {
				System.out.println("Novo contato salvo com sucesso.");
			} else {
				System.out.println("Houve um erro ou faltam dados");
			}
		}
			break;

		case 2: {
			int i = 0;
			for (Contato cont : agenda.listarContatos()) {
				System.out.println(i++ + "- " + cont.getNome() + " " + cont.getTelefone());
			}
		}
			break;
		case 3: {
			System.out.println("Até a próxima");
		}
			break;

		default:
			break;
		}
	}

	private static void mostraMenu() {
		System.out.println("1- Inserir Novo Contato");
		System.out.println("2- Listar todos os Contatos");
		System.out.println("3- Sair");
	}

}
