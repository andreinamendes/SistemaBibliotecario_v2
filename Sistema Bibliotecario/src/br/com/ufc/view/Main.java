package br.com.ufc.view;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.ufc.connection.ConnectionPSQL;

public class Main {
	public static void main(String[] args) {
		ConnectionPSQL connection = new ConnectionPSQL();
		Connection a = connection.getConnection();
		try {
			a.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}