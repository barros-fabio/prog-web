/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Fabio Barros
 */

import java.sql.*;

public class DbConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	// método construtor
	public DbConnect(){
		
	}
	
	// método para conexão com o banco de dados
	public Connection conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conexão estabelecida");
		}catch(Exception ex){
			System.out.println("Erro: "+ex);
		}
		
		String url = "jdbc:mysql://localhost:3306/oficina2";
		String user = "root";
		String password = "root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			st  = con.createStatement();
			System.out.println("Banco de dados conectado!");
		}catch(Exception ex){
			System.out.println("Erro: "+ex);
		}
		
		return con;
	}
	
	// método para consulta no banco de dados
	public void getData(){
		try{
			String query = "select * from usuario";
			rs = st.executeQuery(query);
			System.out.println("Registros do banco de dados");
			while(rs.next()){
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				System.out.println("Nome: "+nome+"login: "+login);
			}
		}catch(Exception ex){
			System.out.println("Erro: "+ex);
		}
	}
}
