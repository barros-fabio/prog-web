/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Src.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author fabio
 */
public class Alunos extends HttpServlet {
    ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();
    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Alunos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Alunos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        /*PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Alunos</title>");        
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Estou no doGet</p>");
        out.println("</body>");
        out.println("</html>");
        */
        
        listAlunos.add(new Aluno("Fabio","Eng. Computação"));
        listAlunos.add(new Aluno("Bruno","Eng. Computação"));
        listAlunos.add(new Aluno("José","Eng. Computação"));
        listAlunos.add(new Aluno("João","Eng. Elétrica"));
        
        JSONObject root = new JSONObject();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        
        for(int i = 0; i<listAlunos.size();i++){
            object.put("nome",listAlunos.get(i).getNome());
            object.put("curso",listAlunos.get(i).getCurso());
            array.add(object);
        }    
        
        root.put("alunos",array);
        
        
        System.out.println(root.toString());
        /*
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Alunos</title>");    
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
        out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");     
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h3>Lista de Alunos</h3>");
        out.println("<ul class=\"nav nav-tabs nav-justified\">");
        out.println("<li class=\"active\"><a href=\"CidadesA\">A</a></li>");
        out.println("<li><a href=\"CidadesB\">B</a></li>");
        out.println("<li><a href=\"CidadesC\">C</a></li>");
        out.println("<li><a href=\"InserirCidade\">Inserir nova cidade</a></li>");
        out.println("</ul>");
        out.println("<br>");
        out.println("<ul class=\"list-group\">");
        */
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
               
        out.print(root);
        out.flush(); 
        
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
