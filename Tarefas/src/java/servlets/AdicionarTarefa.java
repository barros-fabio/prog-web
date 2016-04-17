/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bd.ConectaBanco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Barros
 */
public class AdicionarTarefa extends HttpServlet {
    //Connection con = new ConectaBD().conectaBD();

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
        
        ArrayList<String> tarefas = new ArrayList<>();
  
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
            out.println("<h3>Adicionar nova tarefa</h3>");
            out.println("<ul class=\"nav nav-tabs nav-justified\">");
            out.println("<li><a href=\"Principal\">Visualizar Tarefas</a></li>");
            out.println("<li class=\"active\"><a href=\"AdicionarTarefa\">Adicionar Nova Tarefa</a></li>");
            out.println("</ul>");
            out.println("<form role=\"form\" method=\"POST\" action =\"AdicionarTarefa\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"usr\">Tarefa:</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"tarefa\" name =\"tarefa\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"usr\">Status da tarefa:</label>");
            out.println("<br>");
            out.println("<label for=\"option1\">Iniciada</label>");
            out.println("<input type=\"radio\" name=\"status\" value=\"1\" id=\"iniciada\">");
            out.println("<label for=\"option2\">Pausada</label>");
            out.println("<input type=\"radio\" name=\"status\" value=\"2\" id=\"pausada\">");
            out.println("<label for=\"option3\">Finalizada</label>");
            out.println("<input type=\"radio\" name=\"status\" value=\"3\" id=\"finalizada\">");
            out.println("</div>");
            out.println("<button type = \"submit\"> Enviar </button>");
            out.println("</form>");
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
        String tarefa, status;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        tarefa = request.getParameter("tarefa");
        status = request.getParameter("status");
        
        ConectaBanco cbd = new ConectaBanco();
        Connection c = cbd.conectaBD();
        cbd.insertData(c,"INSERT INTO tarefa (tarefa,status) VALUES (?,?)",tarefa,status);

        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Tarefa adicionada = "+tarefa+"</h1>");
        out.println("<h1>Status da tarefa adicionada = "+status+"</h1>");
        out.println("<a href=\"AdicionarTarefa\"> Voltar </a>");
        out.println("</body>");
        out.println("</html>");
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
