package br.com.ufc.view;

import java.util.Scanner;

public class ViewAluno {
	private Scanner obj = new Scanner(System.in);
	
	public void menuPrincipal() {
		int acao;
		
		while(true) {
			System.out.println("1 - Reservar \n 2 - Renovar \n 0 - Sair");
			acao = obj.nextInt();
			
			if(acao == 0) {
				break;
			}else if(acao == 1) {
				System.out.println("Reservando livro.");
			}else if(acao == 2) {
				System.out.println("Renovando livro");
			}
		}
		
		obj.close();
	}
}
