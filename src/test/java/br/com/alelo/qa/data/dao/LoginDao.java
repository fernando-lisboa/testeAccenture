package br.com.alelo.qa.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alelo.integrations.db.DBConnection;
import br.com.alelo.qa.data.entity.Login;

public class LoginDao {
public Login massaLoginAtivo(String vsts){
		
		Login login = new Login();
		
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT cpf, senha, nascimento ");
        sql.append("FROM tbl_login ");
        sql.append("WHERE vsts=?");
      
        Connection conn = DBConnection.getConnection();
        
        PreparedStatement comando;
		try {
			comando = conn.prepareStatement(sql.toString());
			 comando.setString(1,vsts);
			 ResultSet resultado = comando.executeQuery();
			 
			 while (resultado.next()) {
				 	login.setCpf(resultado.getString("cpf"));
				 	login.setSenha(resultado.getString("senha"));
				 	login.setVsts(vsts);
				 	login.setDatanascimento(resultado.getNString("nascimento"));
		        }

			 resultado.close();
			 comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
		
        
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login;
		
	}
}
