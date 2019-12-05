package br.com.ufc.controller;

import java.util.ArrayList;
import java.util.Scanner;
import br.com.ufc.controller.*;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import br.com.ufc.connection.ConnectionPSQL;

public class LivroController {
	private ConnectionPSQL connectionPSQL;
	private LivroDAO livrodao;
	private Scanner obj;
	private UnidadeController conUnidade;
	
	public LivroController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.livrodao = new LivroDAO(connectionPSQL);
		this.obj = new Scanner(System.in);
		this.conUnidade = new UnidadeController();
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
			System.out.println("Livro " + (a + 1) + ": " + livros.get(a));
		}
	}
	
	public void listarAll() {
		ArrayList<Livro> livros = livrodao.listarLivros();
		if(livros != null)
			for(int a = 0; a < livros.size(); a++) {
				System.out.println("Livro " + (a + 1) + ": " + livros.get(a));
			}
		else
			System.out.println("Nenhum livro no acervo.");
	}
	
	public void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("------------Cadastro Livros------------");
		System.out.print("Titulo: ");
		livro.setTitulo(obj.nextLine());
		System.out.print("Número do acervo: ");
		livro.setNumAcv(obj.nextInt());
		System.out.print("Edição: ");
		livro.setEdicao(obj.nextInt());
		System.out.print("Ano de Lançamento: ");
		livro.setAno_lancamento(obj.nextLine());
		System.out.print("Quantidade de livros: ");
		livro.setQuantidade(obj.nextInt());
		if(!livrodao.inserir(livro))
			System.out.println("Ouve um erro na inserção deste livro.");
		else if(!conUnidade.inserir(livro))
			System.out.println("Ouve um erro na inserção das unidades deste livro.");
		else
			System.out.println("O livro " + livro.getTitulo() + " e suas unidades fora inseridas corretamente!");
	}
}