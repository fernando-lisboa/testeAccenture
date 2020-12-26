package br.com.desafio.integrations.db;

import java.sql.Connection;

public class ConnUsodsadq {
	private static Connection conexao;

	public static Connection getConexao() {
		return conexao;
	}

	public static void setConexao(Connection conexao) {
		ConnUsodsadq.conexao = conexao;
	}

}
