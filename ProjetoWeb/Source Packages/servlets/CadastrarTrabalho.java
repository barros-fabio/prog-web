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
 * @author fabio
 */
public class CadastrarTrabalho extends HttpServlet {
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
        System.out.println("Estou no doGet");
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
        System.out.println("Estou no doPost");
        
        ConectaBanco db = new ConectaBanco();
        Connection con = db.conectaBD();
        String query = "INSERT INTO TCC(titulo, resumo, dataEntrega, dataDefesa, nota, autor, orientador) VALUES (?,?,?,?,?,?,?)";
        String  titulo, resumo, dataEntrega, dataDefesa, nota;
        int aluno,orientador;
        
        
        titulo = request.getParameter("titulo");
        resumo = request.getParameter("resumo");
        dataEntrega = request.getParameter("dataEntrega");
        dataDefesa = request.getParameter("dataDefesa");
        nota = request.getParameter("nota");
        aluno = Integer.parseInt(request.getParameter("aluno"));
        orientador = Integer.parseInt(request.getSession().getAttribute("orientador").toString());
        
        try {
            p = (PreparedStatement) con.prepareStatement(query);
            p.setString(1,titulo);
            p.setString(2,resumo);
            p.setString(3,dataEntrega);
            p.setString(4,dataDefesa);
            p.setString(5,nota);
            p.setInt(6,aluno);
            p.setInt(7,orientador);
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarTrabalho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("  <head>");
        response.getWriter().println("  </head>");
        response.getWriter().println("  <body>");
        response.getWriter().println("      <h1>Trabalho cadastrado com sucesso!</h1>");
        response.getWriter().println("      <a href=\"./page/home.jsp\">Voltar para home</a>");
        response.getWriter().println("  </body>");
        response.getWriter().println("</html>");
        //response.sendRedirect("");
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
