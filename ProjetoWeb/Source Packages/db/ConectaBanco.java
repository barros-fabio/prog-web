/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ConectaBanco {

    private Connection conexao;
    private PreparedStatement p;
    private ResultSet rs;
    private static ArrayList<String> resultados = new ArrayList<>();
   
    public ConectaBanco(){
        
    }
    
    
    public Connection conectaBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexão estabelecida");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root","root");
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            System.out.println("Erro: "+ex);
        }

        return conexao;
    }
    
    public void insertData(Connection conexao, String query, String nome){
        try {
            p = (PreparedStatement) conexao.prepareStatement(query);
            //p.setString(1, nome);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet selectData(Connection conexao, String query){
        try {
            p = (PreparedStatement) conexao.prepareStatement(query);
            rs = p.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ConectaBanco cbd = new ConectaBanco();
        Connection c = cbd.conectaBD();
        cbd.selectData(c,"SELECT * FROM Professor");
        System.out.println(resultados.get(0));
      
    }
    
}
