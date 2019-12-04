package br.com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.ufc.model.Unidade;
import br.com.ufc.connection.ConnectionPSQL;

public class UnidadeDAO implements InterfaceDAO<Unidade>{
	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public UnidadeDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Unidade unidade) {
		String sql = "INSERT INTO unidade(num_reg, num_acv, matricula, data_emp, data_devo, qtd_reno) VALUES(?, ?, ?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			try {
				std.setInt(1, unidade.getNumReg());
				std.setInt(2, unidade.getNumAcv());
				std.setInt(3, unidade.getMatricula());
				std.setDate(4, new java.sql.Date((unidade.getDataEmprestimo()).getTime()));
				std.setDate(5, new java.sql.Date((unidade.getDataDevolucao()).getTime()));
				std.setInt(6, unidade.getQtdRenovacao());
			}catch(ParseException e) {
				System.out.println("");
			}
			
			int execucao = std.executeUpdate();
			std.close();
			if(execucao > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				System.out.println("");
			}
		}		
		return false;
	}

	public boolean atualizar(Unidade unidade) {
		String sql = "UPDATE unidade SET num_reg = ?, num_acv = ?, matricula = ?, data_emp = ?, data_devo = ?, qtd_reno = ? WHERE num_reg = ?";
		
		try {
			this.connection = connectionPSQL.getConnection();
			PreparedStatement std = connection.prepareStatement(sql);
			try {
				std.setInt(1, unidade.getNumReg());
				std.setInt(2, unidade.getNumAcv());
				std.setInt(3, unidade.getMatricula());
				std.setDate(4, new java.sql.Date((unidade.getDataEmprestimo()).getTime()));
				std.setDate(5, new java.sql.Date((unidade.getDataDevolucao()).getTime()));
				std.setInt(6, unidade.getQtdRenovacao());
				std.setInt(7, unidade.getNumReg());
			}catch(ParseException e) {
				System.out.println("");
			}
			
			int execucao = std.executeUpdate();
			std.close();
			if(execucao > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				System.out.println("");
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
			System.out.println("");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				System.out.println("");
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
				unidade.setMatricula(resultado.getInt("matricula"));
				unidade.setDataEmprestimo(resultado.getString("dataEmprestimo"));
				unidade.setDataDevolucao(resultado.getString("dataDevolucao"));
				unidade.setQtdRenovacao(resultado.getInt("qtdRenovacao"));
				
				unidades.add(unidade);
			}
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				connection.close();
			}catch(SQLException e){
				System.out.println("");
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
				unidade.setMatricula(resultado.getInt("matricula"));
				unidade.setDataEmprestimo(resultado.getString("dataEmprestimo"));
				unidade.setDataDevolucao(resultado.getString("dataDevolucao"));
				unidade.setQtdRenovacao(resultado.getInt("qtdRenovacao"));
				
				unidades.add(unidade);
			}
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				connection.close();
			}catch(SQLException e){
				System.out.println("");
			}
		}		
		return unidades;
	}
}
