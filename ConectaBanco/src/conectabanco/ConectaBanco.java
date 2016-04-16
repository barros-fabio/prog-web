/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectabanco;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Fabio Barros
 */
public class ConectaBanco {

    private Connection conexao;
    private PreparedStatement p;
    private ResultSet rs;
   
    public ConectaBanco(){
        
    }
    
    
    public void conectaBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexão estabelecida");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cidades", "root","root");
           
            p = (PreparedStatement) conexao.prepareStatement("SELECT * from cidades");
            rs = p.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        
        try{
            while(rs.next())
                System.out.println(rs.getString("nomeCidade"));
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConectaBanco cbd = new ConectaBanco();
        cbd.conectaBD();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
