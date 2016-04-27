/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bd.ConectaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Barros
 */
public class Principal extends HttpServlet {

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
        ArrayList<String> tarefas = new ArrayList<>();
        PreparedStatement p;
        ResultSet rs;
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lista de Tarefas</title>");    
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
            out.println("<li class=\"active\"><a href=\"Principal\">Visualizar Tarefas</a></li>");
            out.println("<li><a href=\"AdicionarTarefa\">Adicionar Nova Tarefa</a></li>");
            out.println("</ul>");
            out.println("<br>");
            out.println("<ul class=\"list-group\">");
            //cidades = conexaoBD.getData(con,); // conexão com o banco
            
            try{
                p = (PreparedStatement) con.prepareStatement("Select * from tarefas");
                rs = p.executeQuery();
            while(rs.next())
                tarefas.add(rs.getString(1));
            }catch(Exception ex){
                System.out.println("Erro: "+ex);
            }
            
            for(int i=0; i<tarefas.size();i++)    
                out.println("<li class=\"list-group-item\">"+tarefas.get(i)+" <a href =\"Editar\"> Editar </a> <a href = \"Remover\"> Remover </a> </li>");
            
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
