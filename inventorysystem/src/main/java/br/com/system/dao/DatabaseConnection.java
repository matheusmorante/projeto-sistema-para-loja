package br.com.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String url = "jdbc:postgresql://localhost/inventorysystem";
	private static final String user = "postgres";
	private static final String pw = "8877";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexão com o banco de dados concluída");
		} catch (SQLException e) {
			System.out.println("Não foi possível se conectar ao banco de dados: " + e.getMessage());
		}
		return conn;
	}
}