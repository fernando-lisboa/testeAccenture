package br.com.alelo.integrations.db;

import java.sql.Connection;


public class ConnUsadq {
	
	private static Connection conexao;

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		ConnUsadq.conexao = conexao;
	}

}
