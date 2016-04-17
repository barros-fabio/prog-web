/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;


import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Fabio Barros
 */
public class ConectaBD {
    private Connection conexao;
    private PreparedStatement p;
    private ResultSet rs;
   
    public ConectaBD(){
        
    }
    
    
    public Connection conectaBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexão estabelecida");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cidades", "root","root");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        return conexao;
  
   }
    
    public ArrayList<String> getData(Connection conn, String query){
        ArrayList<String> cidades = new ArrayList<>();
        
        try{
            p = (PreparedStatement) conn.prepareStatement(query);
            rs = p.executeQuery();
            while(rs.next())
                cidades.add(rs.getString("nomeCidade"));
                
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        return cidades;
    }
    
}
