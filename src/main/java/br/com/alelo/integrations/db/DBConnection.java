package br.com.alelo.integrations.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alelo.utils.PropertiesFile;

public class DBConnection {


    public enum Ambiente {SIT, HML, PPOINT, BUC, USODSADQ}

    public static Connection getConexao(Ambiente ambiente) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String connUrl = "jdbc:oracle:thin:";
            String user = "";
            String key = "";
            switch (ambiente) {
                case SIT:
                    connUrl = connUrl + "@10.40.89.38:1521/ibi";
                    user = "DES_PWC_BI";
                    key = "Alelo_2016";
                    break;
                case HML:
                    connUrl = connUrl + "@10.40.89.36:1521/HCORP";
                    user = "USADQ";
                    key = "Al3lo_";
                    break;
                case PPOINT:
                    connUrl = connUrl + "@10.40.89.36:1521/HCORP";
                    user = "USPPOINT";
                    key = "Al3lo_";
                    break;
                case BUC:
                    connUrl = connUrl + "@10.236.2.38:1521/HCAD";
                    user = "USPORTALEC";
                    key = "Al3lo_";
                    break;
				case USODSADQ:
					connUrl = connUrl + "@10.40.89.36:1521/HCAD";
					user = "USODSADQ";
					key = "Al3lo_";
					break;
            }
            Connection conn = DriverManager.getConnection(connUrl, user, key);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

/*
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
*/

}
