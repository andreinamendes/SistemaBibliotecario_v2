package br.com.ufc.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.ufc.controller.*;
import br.com.ufc.model.*;

public class Application {
	private Scanner obj;
	private AlunoController conAluno;
	private LivroController conLivro;
	private ServidorController conServidor;
	private UnidadeController conUnidade;
	private TelefoneController conTelefone;
	private EmprestimoController conEmprestimo;
	Aluno alunoLogado = new Aluno();
	Servidor servidorLogado = new Servidor();
	
	public Application() {
		this.obj = new Scanner(System.in);
		this.conAluno = new AlunoController();
		this.conLivro = new LivroController();
		this.conServidor = new ServidorController();
		this.conUnidade = new UnidadeController();
		this.conTelefone = new TelefoneController();
		this.conEmprestimo = new EmprestimoController();
	}
	
	public void telaLogin() throws ParseException {
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
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	} 
	
	public void loginAluno() throws ParseException {
		int opcao;
		System.out.println("\n------------Aluno------------");
		System.out.print("\nMatricula: ");
		alunoLogado.setMatricula(obj.nextInt());
		System.out.print("Senha: ");
		alunoLogado.setSenha(obj.nextLine());
		alunoLogado.setSenha(obj.nextLine());
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n-----------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				if(conAluno.login(alunoLogado.getSenha(), alunoLogado.getMatricula()))
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
	
	public void loginServidor() throws ParseException {
		int opcao;
		System.out.println("\n------------Servidor------------");
		System.out.print("\nSiape: ");
		servidorLogado.setSiape(obj.nextInt());
		System.out.print("Senha: ");
		servidorLogado.setSenha(obj.nextLine());
		servidorLogado.setSenha(obj.nextLine());
		System.out.println("\n	1 - Login");
		System.out.println("	2 - Voltar");
		System.out.println("\n--------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				if(conServidor.login(servidorLogado.getSenha(), servidorLogado.getSiape()))
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
	
	public void menuAluno() throws ParseException {
		int opcao;
		System.out.println("\n------------Menu Aluno------------");
		System.out.println("\n	1 - Meus livros");
		System.out.println("	2 - Pesquisar livros");
		System.out.println("	3 - Sair");
		System.out.println("\n----------------------------------");
		System.out.print("\nDigite a opção desejada: ");
		
		do {
			opcao = obj.nextInt();
			if(opcao == 1) {
				if(!conAluno.listarEmprestimos(alunoLogado))
					menuAluno();
				else {
					int opcao1;
					System.out.println("\n\t 1 - Renovar");
					System.out.println("\t 2 - Voltar");
					System.out.print("\nDigite a opção: ");
					opcao1 = obj.nextInt();
					if(opcao1 == 1) {
						renovarEmprestimo();
						menuAluno();
					}else
						menuAluno();
				}
				break;
			}else if(opcao == 2) {
				
			}else if(opcao == 3) {
				telaLogin();
				break;
			}else 
				System.out.print("Opção inválida, digite novamente: ");
		}while(true);
	}
	
	public void alugarLivro() {
		
	}
	
	public void renovarEmprestimo() {
		int id;
		System.out.print("Digite o número de registro do livro a ser renovado: ");
		id = obj.nextInt();
		ArrayList<Emprestimo> emprestimos = conEmprestimo.getEmprestimos(alunoLogado);
		for(int a = 0; a < emprestimos.size(); a++) {
			if(emprestimos.get(a).getNumReg() == id) {
				conEmprestimo.renovarEmprestimo(emprestimos.get(a));
				System.out.println("Renovado com sucesso!\n");
				return;
			}
		}
	}
	
	public void menuServidor() throws ParseException {
		int opcao;
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