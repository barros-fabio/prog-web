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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class Login extends HttpServlet {
    private ResultSet rs;
    private String username;
    private String password;

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
        response.getWriter().println("<h1> estou no get</h1>");
        
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
        
        
        try{
            ConectaBanco db = new ConectaBanco();
            Connection con = db.conectaBD();
            
            rs = db.selectData(con, "SELECT usuario, senha FROM Professor"); // MUDAR ESSA LÓGICA!!! PROCESSAMENTO DE DADOS MUITO ALTO!!!!
            while(rs.next()){ // ITERAÇÂO SOBRE MUITAS CONSULTAS!!!!
                username = rs.getString("usuario");
                password = rs.getString("senha");
                
                if(request.getParameter("login").equals(username)&& request.getParameter("inputPassword").equals(password)){
                    request.getSession().setAttribute("logado",new Boolean(true));
                    request.getSession().setAttribute("user",username);
                    //request.getSession().setMaxInactiveInterval(30);
                    response.sendRedirect("./page/home.jsp");
                }else{
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().println("<h1> Proibido!!!</h1>");
                }
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
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
