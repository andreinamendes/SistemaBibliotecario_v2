package br.com.ufc.controller;

import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;

public class AlunoController {
	private ConnectionPSQL connectionPSQL;
	private AlunoDAO alunodao;
	private Scanner obj;
	
	public AlunoController() {
		this.connectionPSQL = new ConnectionPSQL();
		this.alunodao = new AlunoDAO(connectionPSQL);
		this.obj = new Scanner(System.in);
	}
	
	public boolean login(String senha, int matricula) {
		Aluno aluno = alunodao.buscar(senha, matricula);
		if(aluno != null)
			return true;
		return false;
	}
	
	public boolean cadastrarAluno() {
		Usuario usuario = new Usuario();
		Aluno aluno = new Aluno();
		int qtd;
		System.out.println("------------Cadastro Aluno------------");
		System.out.print("Nome: ");
		usuario.setNome(obj.nextLine());
		System.out.print("Senha: ");
		usuario.setSenha(obj.nextLine());
		System.out.print("E-mail: ");
		usuario.setEmail(obj.nextLine());
		System.out.print("CPF: ");
		usuario.setCpf(obj.nextLine());
		System.out.print("Rua: ");
		usuario.setCpf(obj.nextLine());
		System.out.print("Numero: ");
		usuario.setNumero(obj.nextLine());
		System.out.print("Cidade: ");
		usuario.setCidade(obj.nextLine());
		System.out.print("Estado: ");
		usuario.setEstado(obj.nextLine());
		System.out.print("Matricula: ");
		aluno.setMatricula(obj.nextInt());
		System.out.print("Curso: ");
		aluno.setCurso(obj.nextLine());
		System.out.print("Quantos telefones deseja inserir? ");
		qtd = obj.nextInt();
		for(int a = 0; a < qtd; a++) {
			Telefone telefone = new Telefone();
			System.out.println("DDD: ");
			telefone.setDdd(obj.nextLine());
			System.out.println("Número, lembre-se do 9: ");
			telefone.setNumero(obj.nextLine());
			usuario.setTelefone(telefone);
		}
		if(alunodao.inserir(usuario, aluno))
			System.out.println("Aluno " + usuario.getNome() + " cadastrado com sucesso!");
		else
			System.out.println("Erro, aluno não cadastrado.");
		return false;
	}
}