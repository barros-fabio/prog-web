/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bd.ConectaBD;
import com.mysql.jdbc.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class CidadesA extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ConectaBD conexaoBD = new ConectaBD();
        Connection con = conexaoBD.conectaBD();
        ArrayList<String> cidades = new ArrayList<>();
        PreparedStatement p;
        ResultSet rs;
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CidadesA</title>");    
            out.println("<meta charset=\"utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
            out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");     
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h3>Lista de Cidades</h3>");
            out.println("<ul class=\"nav nav-tabs nav-justified\">");
            out.println("<li class=\"active\"><a href=\"CidadesA\">A</a></li>");
            out.println("<li><a href=\"CidadesB\">B</a></li>");
            out.println("<li><a href=\"CidadesC\">C</a></li>");
            out.println("<li><a href=\"InserirCidade\">Inserir nova cidade</a></li>");
            out.println("</ul>");
            out.println("<br>");
            out.println("<ul class=\"list-group\">");
            //cidades = conexaoBD.getData(con,); // conexão com o banco
            
            try{
                p = (PreparedStatement) con.prepareStatement("Select * from cidades;");
                rs = p.executeQuery();
            while(rs.next())
                cidades.add(rs.getString("nomeCidade"));
            }catch(Exception ex){
                System.out.println("Erro: "+ex);
            }
            
            for(int i=0; i<cidades.size();i++)    
                out.println("<li class=\"list-group-item\">"+cidades.get(i)+"</li>");
            
            out.println("</ul>");
            out.println("</div>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
