package br.com.alelo.integrations.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alelo.utils.PropertiesFile;

public class DBConnection {

	public static Connection getConnectionSit() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connUrl = "jdbc:oracle:thin:@10.40.89.38:1521/ibi";
			Connection conn = DriverManager.getConnection(connUrl, "DES_PWC_BI", "Alelo_2016");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Connection getConnectionHml() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connUrl = "jdbc:oracle:thin:@10.40.89.36:1521/HCORP";
			Connection conn = DriverManager.getConnection(connUrl, "USODSADQ", "Al3lo_");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Connection getConnectionPpoint() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connUrl = "jdbc:oracle:thin:@10.40.89.36:1521/HCORP";
			Connection conn = DriverManager.getConnection(connUrl, "USPPOINT", "Al3lo_");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Connection getConnectionBuc() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connUrl = "jdbc:oracle:thin:@10.236.2.38:1521/HCAD";
			Connection conn = DriverManager.getConnection(connUrl, "USPORTALEC", "Al3lo_");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
