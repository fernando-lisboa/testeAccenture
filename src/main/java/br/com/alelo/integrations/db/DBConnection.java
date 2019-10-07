package br.com.alelo.integrations.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alelo.utils.PropertiesFile;

public class DBConnection {

	private static final String USUARIO = "framework";
	private static final String SENHA = "testes@123";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	static String status = "";

	public static Connection getConnection() {
		try {
			PropertiesFile props = new PropertiesFile();
			Class.forName("com.mysql.jdbc.Driver");
			String connUrl = "jdbc:mysql://10.150.41.150:3306/" + props.getValor("db")
					+ "?autoReconnect=true&useSSL=false";
			Connection conn = DriverManager.getConnection(connUrl, "framework", "testes@123");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
