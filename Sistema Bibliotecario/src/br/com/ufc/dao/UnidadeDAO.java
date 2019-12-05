package br.com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufc.model.Unidade;
import br.com.ufc.connection.ConnectionPSQL;

public class UnidadeDAO{
	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public UnidadeDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Unidade unidade) {
		String sql = "INSERT INTO unidade(num_reg, num_acv) VALUES(?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, unidade.getNumReg());
			std.setInt(2, unidade.getNumAcv());
			int execucao = std.executeUpdate();
			std.close();
			if(execucao > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}		
		return false;
	}

	public boolean remover(Unidade unidade) {
		String sql = "DELETE FROM unidade WHERE num_reg = ?";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, unidade.getNumReg());
			
			int execucao = std.executeUpdate();
			std.close();
			if(execucao > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public ArrayList<Unidade> buscar(String key) {
		ArrayList<Unidade> unidades = new ArrayList<Unidade>();
		int reg = Integer.parseInt(key);
		String sql = "SELECT * from unidade WHERE num_reg LIKE %?%;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, reg);
			ResultSet resultado = std.executeQuery();
			while(resultado.next()) {
				Unidade unidade = new Unidade();
				unidade.setNumReg(resultado.getInt("num_reg"));
				unidade.setNumAcv(resultado.getInt("num_acv"));
				
				unidades.add(unidade);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}		
		return unidades;
	}
	
	public ArrayList<Unidade> listaUnidades(int numAcv){
		ArrayList<Unidade> unidades = new ArrayList<Unidade>();
		String sql = "SELECT * from unidade WHERE num_acv = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, numAcv);
			ResultSet resultado = std.executeQuery();
			while(resultado.next()) {
				Unidade unidade = new Unidade();
				unidade.setNumReg(resultado.getInt("num_reg"));
				unidade.setNumAcv(resultado.getInt("num_acv"));
				
				unidades.add(unidade);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}		
		return unidades;
	}
}