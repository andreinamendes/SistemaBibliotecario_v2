package br.com.ufc.view;

import java.io.IOException;
import java.util.Scanner;
import br.com.ufc.controller.*;

public class Application {
	private Scanner obj = new Scanner(System.in);
	private AlunoController conALuno = new AlunoController();
	private LivroController conLivro = new LivroController();
	private ServidorController conServidor = new ServidorController();
	private UnidadeController conUnidade = new UnidadeController();
	private TelefoneController conTelefone = new TelefoneController();
	
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
				try {
					Runtime.getRuntime().exec("clear");
					loginAluno();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
		int opcao;
		
		System.out.println("\n------------Aluno------------");
		System.out.print("\nUsuário: ");
		login = obj.nextLine();
		login = obj.nextLine();
		System.out.print("Senha: ");
		senha = obj.nextLine();
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n-----------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				//Chama a vereificação de login.
				menuAluno();
				break;
			}else if(opcao == 2) {
				telaLogin();
				break;
			}else 
				System.out.println("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void loginServidor() {
		String senha;
		String login;
		int opcao;
		System.out.println("\n------------Servidor------------");
		System.out.print("\nUsuário: ");
		login = obj.nextLine();
		login = obj.nextLine();
		System.out.print("Senha: ");
		senha = obj.nextLine();
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n--------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				//Chama a vereificação de login.
				menuServidor();
				break;
			}else if(opcao == 2) {
				telaLogin();
				break;
			}else 
				System.out.println("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void menuAluno() {
		int opcao;
		System.out.println("\n------------Menu Aluno------------");
		System.out.println("\n	1 - Meus livros");
		System.out.println("	2 - Pesquisar livros");
		System.out.println("	4 - Sair");
		System.out.println("\n----------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				listarLivrosAlugados();
				break;
			}else if(opcao == 2) {
				pesquisarLivros();
				break;
			}else if(opcao == 3) {
				telaLogin();
				break;
			}else 
				System.out.println("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void listarLivrosAlugados() {
		
	}
	
	public void pesquisarLivros() {
		
	}
	
	public void menuServidor() {
		int opcao;
		System.out.println("\n------------Menu Servidor------------");
		System.out.println("\n	1 - Listar Acervo");
		System.out.println("	2 - Recebimetos");
		System.out.println("	3 - Cadastros");
		System.out.println("	3 - Sair");
		System.out.println("\n-------------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				listarAcervo();
				break;
			}else if(opcao == 2) {
				recebimento();
				break;
			}else if(opcao == 3) {
				cadastros();
				break;
			}else if(opcao == 4) {
				telaLogin();
				break;
			}else 
				System.out.println("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void listarAcervo() {
		
	}
	
	public void cadastros() {
		
	}
	
	public void recebimento() {
		
	}
}
