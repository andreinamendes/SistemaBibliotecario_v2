package br.com.ufc.view;

import java.util.Scanner;

public class ViewServidor {
	private Scanner obj = new Scanner(System.in);
	
	public void menuPrincipal() {
		int acao;
		
		while(true) {
			System.out.println("1 - Alugar \n 2 - Receber \n 0 - Sair");
			acao = obj.nextInt();
			
			if(acao == 0) {
				break;
			}else if(acao == 1) {
				System.out.println("Alugando livro.");
				menuAlugar();
			}else if(acao == 2) {
				System.out.println("Recebendo livro.");
				menuReceber();
			}
		}		
		obj.close();
	}
	
	private void menuAlugar() {
		int matricula;
		int num_reg;
		System.out.println("0 - Retornar");
		
		System.out.println("Digite a matricula do aluno: ");
		matricula = obj.nextInt();
		if(matricula == 0) {
			return;
		}
		
		System.out.println("Digite o numero de acervo do livro: ");
		num_reg = obj.nextInt();
		if(num_reg == 0) {
			return;
		}
		
		//Alugar(matricula, num_reg)		
	}
	
	private void menuReceber() {
		int matricula;
		int num_reg;
		System.out.println("0 - Retornar");
		
		System.out.println("Digite a matricula do aluno: ");
		matricula = obj.nextInt();
		if(matricula == 0) {
			return;
		}
		
		System.out.println("Digite o numero de acervo do livro: ");
		num_reg = obj.nextInt();
		if(num_reg == 0) {
			return;
		}
		
		//Receber(matricula, num_reg)
	}
	
}
