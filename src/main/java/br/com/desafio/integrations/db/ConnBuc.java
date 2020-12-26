package br.com.desafio.integrations.db;

import java.sql.Connection;


public class ConnBuc {
	
	private static Connection conexao;

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		ConnBuc.conexao = conexao;
	}

}
