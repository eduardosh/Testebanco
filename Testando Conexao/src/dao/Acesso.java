package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class Acesso {
	
	public boolean acesso;
	
	public void Acesso(String login, String senha){
		Connection con = null;
		Statement consulta = null;
		ResultSet tabela = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/db_tradehelper","root","");
			consulta = (Statement) con.createStatement();
			tabela = consulta.executeQuery("select login, senha from tbl_usuario where login='"+login+"'and senha='"+senha+"'");
			if(tabela.next()){
			//	JOptionPane.showMessageDialog(null, "Usuario e Senha Corretos!");
				acesso=true;
			} else{
				JOptionPane.showMessageDialog(null, "Usuario ou Senha incorretos");
				acesso=false;
			}
			
		} catch(ClassNotFoundException |SQLException e){
			
		}
		
		
		
		
	}

}
