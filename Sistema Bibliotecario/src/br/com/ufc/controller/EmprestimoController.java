package br.com.ufc.controller;

import java.text.ParseException;
import java.util.ArrayList;

import br.com.ufc.connection.*;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;

public class EmprestimoController {
	private ConnectionPSQL connectionPSQL;
	private EmprestimoDAO emprestimodao;
	private LivroController conLivro; 
	
	public EmprestimoController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.emprestimodao = new EmprestimoDAO(connectionPSQL);
		this.conLivro = new LivroController();
	}
	
	public void listarEmprestimos(Aluno aluno) throws ParseException{
		ArrayList<Emprestimo> emprestimos = emprestimodao.listarEmprestimos(aluno);
		if(emprestimos != null)
			for(int a = 0; a < emprestimos.size(); a++) {
				System.out.println("Empréstimo " + (a + 1) + ":");
				System.out.println("\t Livro: " + conLivro.buscarRegistro(emprestimos.get(a).getNumReg()).getTitulo());
				System.out.println("\t Data de empréstimo: " + emprestimos.get(a).getDataEmp());
				System.out.println("\t Data de devolução: " + emprestimos.get(a).getDataDevo());
				System.out.println("\t Quantidade de renovações: " + emprestimos.get(a).getQtdReno());
			}
		else
			System.out.println("O aluno não tem nenhum empréstimo em aberto.");
	}
}