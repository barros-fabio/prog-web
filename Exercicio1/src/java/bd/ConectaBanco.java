/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Fabio Barros
 */
public class ConectaBanco {

    private Connection conexao;
    private PreparedStatement p;
    private ResultSet rs;
    private ArrayList<String> cidades = new ArrayList<>();

   
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
    
    public void insertData(Connection conexao, String query, String cidade, String estado){
        try {
            p = (PreparedStatement) conexao.prepareStatement(query);
            p.setString(1, cidade);
            p.setString(2, estado);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<String> selectData(Connection conexao, String query){
        try {
            p = (PreparedStatement) conexao.prepareStatement(query);
            rs = p.executeQuery();
            
            while(rs.next())
                cidades.add(rs.getString(1));
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cidades;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nome = "José";
        ConectaBanco cbd = new ConectaBanco();
        Connection c = cbd.conectaBD();
        cbd.selectData(c,"Select * from pessoa");
        //cbd.insertData(c,"INSERT INTO Pessoa (nome) VALUES (?)", nome);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
