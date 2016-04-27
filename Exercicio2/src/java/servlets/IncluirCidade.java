/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class IncluirCidade extends HttpServlet {


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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Cidades</title>");    
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
        out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");     
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h2>Adicionar nova cidade</h2>");
        out.println("<p>Digite abaixo o nome da nova cidade a ser adicionada</p>");
        out.println("<form role=\"form\" method=\"POST\" action = \"IncluirCidade\">");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"usr\">Nome da Cidade:</label>");
        out.println("<input type=\"text\" class=\"form-control\" id=\"nomeCidade\" name =\"nomeCidade\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"usr\">Estado:</label>");
       
        out.println("<input type=\"text\" class=\"form-control\" id=\"usr\">");
        out.println("</div>");
        out.println("<button type = \"submit\"> Enviar </button>");
        out.println("</form>");
        out.println("<br>");
        out.println("</div>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getParameter("nomeCidade");
        FileWriter fw = new FileWriter("/home/fabio/NetBeansProjects/Exercicio2/src/java/cidades/CidadesA.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(request.getParameter("nomeCidade"));
        bw.close();
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
