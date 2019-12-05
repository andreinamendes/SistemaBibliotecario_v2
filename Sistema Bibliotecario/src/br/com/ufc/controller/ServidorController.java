package br.com.ufc.controller;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import br.com.ufc.controller.LivroController;

public class ServidorController {
	private ConnectionPSQL connectionPSQL;
	private ServidorDAO servidordao;
	private LivroController conLivro;
	private AlunoController conAluno;
	
	public ServidorController() {
		this.servidordao = new ServidorDAO(connectionPSQL);
		this.connectionPSQL = new ConnectionPSQL();
		this.conLivro = new LivroController();
		this.conAluno = new AlunoController();
	}
	
	public boolean login(String senha, int siape) {
		Servidor servidor = servidordao.buscar(senha, siape);
		if(servidor != null)
			return true;
		return false;
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
}