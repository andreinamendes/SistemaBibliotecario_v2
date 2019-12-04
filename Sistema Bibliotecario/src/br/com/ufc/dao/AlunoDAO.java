package br.com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufc.model.Aluno;
import br.com.ufc.connection.ConnectionPSQL;

public class AlunoDAO implements InterfaceDAO<Aluno>{
	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public AlunoDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Aluno t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atualizar(Aluno t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remover(Aluno t) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Aluno> buscar(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
