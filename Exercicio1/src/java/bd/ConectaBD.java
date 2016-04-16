/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
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
    
    
    public void conectaBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexão estabelecida");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cidades", "root","root");
           
            p = (PreparedStatement) conexao.prepareStatement("SELECT * from cidades;");
            rs = p.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        try{
            while(rs.next())
                System.out.println(rs.getString("cidade"));
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }

        
   }
    
}
