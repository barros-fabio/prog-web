/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
public class Login extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("   <title>Servlet Login</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1> Servlet Login </h1>");
        out.println("   <form role =\"form\" action = \"Login\" method = \"post\">");
        out.println("       <input type=\"text\" name = \"login\">");
        out.println("       <br>");
        out.println("       <input type=\"password\" name = \"password\">");
        out.println("       <br>");
        out.println("       <input type=\"submit\" value =\" Submit\">");
        out.println("   </form>");
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
        if(request.getParameter("login").equals("fabio") && request.getParameter("password").equals("1234")){
            request.getSession().setAttribute("logado", new Boolean(true));
            request.getSession().setAttribute("user", "fabio");
            request.getSession().setMaxInactiveInterval(15);
            response.sendRedirect("PaginaProtegida");
            
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().println("<h1> Proibido!!!</h1> ");
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
