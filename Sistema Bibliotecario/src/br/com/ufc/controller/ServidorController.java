package br.com.ufc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import br.com.ufc.controller.LivroController;

public class ServidorController {
	private ConnectionPSQL connectionPSQL;
	private ServidorDAO servidordao;
	private LivroController conLivro;
	private AlunoController conAluno;
	private EmprestimoController conEmprestimo;
	private Scanner obj;
	
	public ServidorController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.servidordao = new ServidorDAO(connectionPSQL);
		this.conLivro = new LivroController();
		this.conAluno = new AlunoController();
		this.conEmprestimo = new EmprestimoController();
		this.obj = new Scanner(System.in);
	}
	
	public boolean login(String senha, int siape) {
		Servidor servidor = servidordao.buscar(senha, siape);
		if(servidor != null)
			return true;
		return false;
	}
	
	public void buscarLivro() {
		String titulo;
		System.out.print("Digite o titulo do livro que deseja buscar: ");
		titulo = obj.nextLine();
		conLivro.buscar(titulo);
	}
	
	public void listarAcervo() {
		conLivro.listarAll();
	}
	
	public void cadastrarLivro() {
		conLivro.cadastrarLivro();
	}
	
	public void cadastrarAluno() {
		conAluno.cadastrarAluno();
	}
	
	public void receberEmprestimo(Aluno aluno) {
		ArrayList<Emprestimo> emprestimo = conEmprestimo.getEmprestimos(aluno);
	}
}