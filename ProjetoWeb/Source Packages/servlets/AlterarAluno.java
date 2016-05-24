/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import db.ConectaBanco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio Barros
 */
public class AlterarAluno extends HttpServlet {

    PreparedStatement p;

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
       
        request.setCharacterEncoding( "UTF-8" );
        
        ConectaBanco db = new ConectaBanco();
        Connection con = db.conectaBD();
        String  nome, cpf, ra, curso, periodo;
      
        nome = request.getParameter("nome");
        cpf = request.getParameter("cpf");
        ra = request.getParameter("ra");
        curso = request.getParameter("curso");
        periodo = request.getParameter("periodo");
        String query = "UPDATE Aluno SET nomeAluno = '"+nome+"', CPF ='"+cpf+"', RA = '"+ra+"', curso ='"+curso+"', periodo='"+periodo+"'";
        
        try {
            p = (PreparedStatement) con.prepareStatement(query); 
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("  <head>");
        response.getWriter().println("      <link href=\"./style/bootstrap.min.css\" rel=\"stylesheet\">");
        response.getWriter().println("      <link href=\"./style/navbar.css\" rel=\"stylesheet\">");
        response.getWriter().println("  </head>");
        response.getWriter().println("  <body>");
        response.getWriter().println("      <h1>Dados do aluno foram alterados com sucesso!</h1>");
        response.getWriter().println("      <a href=\"./page/home.jsp\">Voltar para home</a>");
        response.getWriter().println("  </body>");
        response.getWriter().println("</html>");
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
