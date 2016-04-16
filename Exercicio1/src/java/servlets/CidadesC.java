/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CidadesC extends HttpServlet {

    

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
        File arquivo;
        
        
        arquivo = new File("/home/fabio/NetBeansProjects/Exercicio1/src/java/cidades/CidadesC.txt");
        
        if(arquivo.isDirectory()){
            String[] arquivos = arquivo.list();
            for (String arquivo1 : arquivos) {
                System.out.println(arquivo1);
            }
        }else{
            FileReader leitor;
            try {
                leitor = new FileReader(arquivo);
                BufferedReader in = new BufferedReader(leitor);
                String line;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CidadesC</title>");    
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
                out.println("<li><a href=\"CidadesA\">A</a></li>");
                out.println("<li><a href=\"CidadesB\">B</a></li>");
                out.println("<li class=\"active\"><a href=\"CidadesC\">C</a></li>");
                out.println("</ul>");
                out.println("<br>");
                out.println("<ul class=\"list-group\">");
                while((line = in.readLine())!= null){
                    out.println("<li class=\"list-group-item\">"+line+"</li>");
                }
                out.println("</ul>");
                out.println("</div>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");    
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CidadesA.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CidadesA.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
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
