package br.com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufc.model.Telefone;
import br.com.ufc.connection.ConnectionPSQL;

public class TelefoneDAO {
	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public TelefoneDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir() {
		return false;
	}
	
	public boolean atualizar() {
		return false;
	}
	
	public boolean remover() {
		return false;
	}
	
	public ArrayList<Telefone> listaTelefones(){
		return new ArrayList<Telefone>();
	}

}
