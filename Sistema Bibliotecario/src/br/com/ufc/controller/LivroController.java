package br.com.ufc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufc.dao.LivroDAO;
import br.com.ufc.model.Livro;
import br.com.ufc.connection.ConnectionPSQL;

public class LivroController {
	private ConnectionPSQL connectionPSQL;
	private LivroDAO livrodao;
	private Scanner obj;
	
	public LivroController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.livrodao = new LivroDAO(connectionPSQL);
		this.obj = new Scanner(System.in);
	}
	
	public void buscar(){
		String titulo;
		System.out.print("Digite o titulo do livro que deseja buscar: ");
		titulo = obj.nextLine();
		ArrayList<Livro> livros = livrodao.buscar(titulo);
		if(livros != null)
			listarEspecificos(livros);
		else
			System.out.println("Livro não encontrado.");
	}
	
	public void listarEspecificos(ArrayList<Livro> livros) {
		for(int a = 0; a < livros.size(); a++) {
			System.out.println("Livro " + a + 1 + ": " + livros.get(a));
		}
	}
	
	public void listarAll() {
		ArrayList<Livro> livros = livrodao.listarLivros();
		if(livros != null)
			for(int a = 0; a < livros.size(); a++) {
				System.out.println("Livro " + a + 1 + ": " + livros.get(a));
			}
		else
			System.out.println("Nenhum livro no acervo.");
	}
	
	public boolean cadastrarLivro() {
		return false;
	}
}