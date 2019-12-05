package br.com.ufc.view;

import java.util.ArrayList;
import java.util.Scanner;
import br.com.ufc.controller.*;
import br.com.ufc.model.Livro;

public class Application {
	private Scanner obj;
	private AlunoController conAluno;
	private LivroController conLivro;
	private ServidorController conServidor;
	private UnidadeController conUnidade;
	private TelefoneController conTelefone;
	
	public Application() {
		this.obj = new Scanner(System.in);
		this.conAluno = new AlunoController();
		this.conLivro = new LivroController();
		this.conServidor = new ServidorController();
		this.conUnidade = new UnidadeController();
		this.conTelefone = new TelefoneController();
	}
	
	public void telaLogin() {
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
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
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	} 
	
	public void loginAluno() {
		String senha;
		int matricula;
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n------------Aluno------------");
		System.out.print("\nMatricula: ");
		matricula = obj.nextInt();
		System.out.print("Senha: ");
		senha = obj.nextLine();
		senha = obj.nextLine();
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n-----------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				if(conAluno.login(senha, matricula))
					menuAluno();
				else {
					System.out.println("Senha ou matrícula inválida. Tente novamente mais tarde.");
					telaLogin();
					break;
				}
			}else if(opcao == 2) {
				telaLogin();
				break;
			}else 
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void loginServidor() {
		String senha;
		int siape;
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n------------Servidor------------");
		System.out.print("\nSiape: ");
		siape = obj.nextInt();
		System.out.print("Senha: ");
		senha = obj.nextLine();
		senha = obj.nextLine();
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n--------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				if(conServidor.login(senha, siape))
					menuServidor();
				else {
					System.out.println("Senha ou matrícula inválida. Tente novamente mais tarde.");
					telaLogin();
					break;
				}
				break;
			}else if(opcao == 2) {
				telaLogin();
				break;
			}else 
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void menuAluno() {
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n------------Menu Aluno------------");
		System.out.println("\n	1 - Meus livros");
		System.out.println("	2 - Pesquisar livros");
		System.out.println("	3 - Sair");
		System.out.println("\n----------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				//Função de listar livros alugados na controller do aluno
				break;
			}else if(opcao == 2) {
				conLivro.buscar();
				break;
			}else if(opcao == 3) {
				telaLogin();
				break;
			}else 
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void menuServidor() {
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n------------Menu Servidor------------");
		System.out.println("\n	1 - Listar Acervo");
		System.out.println("	2 - Recebimetos");
		System.out.println("	3 - Cadastros");
		System.out.println("	4 - Pesquisar");
		System.out.println("	5 - Sair");
		System.out.println("\n-------------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				conServidor.listarAcervo();
				break;
			}else if(opcao == 2) {
				//Função de recebimento na controller do servidor
				break;
			}else if(opcao == 3) {
				cadastros();
				break;
			}else if(opcao == 4) {
				conLivro.buscar();
				break;
			}else if(opcao == 5) {
				telaLogin();
				break;
			}else 
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void cadastros() {
		int opcao;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n---------------Cadastro--------------");
		System.out.println("\n	1 - Aluno");
		System.out.println("	2 - Livro");
		System.out.println("\n-------------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1)
				conServidor.cadastrarAluno();
			else if(opcao == 2)
				conServidor.cadastrarLivro();
			else
				System.out.print("Opção inválida. Digite novamente: ");
		}while(true);
	}
}