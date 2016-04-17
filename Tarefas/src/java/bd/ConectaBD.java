/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import java.sql.*;

/**
 *
 * @author Fabio Barros
 */
public class ConectaBD {
    Connection conexao;
    
    public ConectaBD(){
        
    }
    
    public Connection conectaBD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas","root","root");
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        return conexao;
    }
}
