package br.com.ufc.controller;

import java.util.ArrayList;

import br.com.ufc.connection.*;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;

public class EmprestimoController {
	private ConnectionPSQL connectionPSQL;
	private EmprestimoDAO emprestimodao;
	
	public EmprestimoController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.emprestimodao = new EmprestimoDAO(connectionPSQL);
	}
	
	public void listarEmprestimos(Aluno aluno) {
		ArrayList<Emprestimo> emprestimos = emprestimodao.listarEmprestimos(aluno);
		if(emprestimos != null) {
			for() {
				
			}
		}
	}
}
