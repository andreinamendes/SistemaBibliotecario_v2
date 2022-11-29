package br.com.ufc.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.view.Application;

public class Main{
	public static void main(String[] args){
		ConnectionPSQL connection = new ConnectionPSQL();
		Connection a = connection.getConnection();
		System.out.println("Conectado");
		
		try {
			a.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Application ap = new Application();
		
		try {
			ap.telaLogin();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}