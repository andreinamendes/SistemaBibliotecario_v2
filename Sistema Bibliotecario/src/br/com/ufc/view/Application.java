package br.com.ufc.view;

import java.io.Console;
import java.util.Scanner;

public class Application {
	private Scanner obj = new Scanner(System.in);
	
	public void telaLogin() {
		int opcao;
		System.out.println("\n------------Login------------");
		System.out.println("\n	1 - Aluno");
		System.out.println("	2 - Servidor");
		System.out.println("	3 - Sair");
		System.out.println("\n-----------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				loginAluno();
				break;
			}else if(opcao == 2) {
				loginServidor();
				break;
			}else if(opcao == 3)
				System.exit(0);
			else 
				System.out.println("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void loginAluno() {
		String senha;
		String login;
		System.out.println("\n------------Aluno------------");
		System.out.println("\nUsuário: ");
		login = obj.nextLine();
		System.out.println("Senha: ");
		senha = obj.nextLine();
		System.out.println("Voltar");
		System.out.println("\n-----------------------------");

//		do {
//			opcao = obj.nextInt();
//			if(opcao == 1) {
//				loginAluno();
//				break;
//			}else if(opcao == 2) {
//				loginServidor();
//				break;
//			}else if(opcao == 3)
//				System.exit(0);
//			else 
//				System.out.println("Opção inválida, digite novamente: ");
//		}while(true);
	}
	
	public void loginServidor() {
		
	}
	
	public void menuAluno() {
		
	}
	
	public void menuServidor() {
		
	}
}
