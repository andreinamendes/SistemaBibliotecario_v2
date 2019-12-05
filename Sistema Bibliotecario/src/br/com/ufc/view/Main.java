package br.com.ufc.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import br.com.ufc.connection.ConnectionPSQL;

public class Main {
	public static void main(String[] args) throws ParseException {
//		ConnectionPSQL connection = new ConnectionPSQL();
//		Connection a = connection.getConnection();
//		System.out.println("Conectado");
//		try {
//			a.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Application ap = new Application();
		ap.telaLogin();
	}
}