package br.com.alelo.integrations.db;

import java.sql.Connection;


public class ConnPpoint {
	private static Connection conexao;

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		ConnPpoint.conexao = conexao;
	}


}
