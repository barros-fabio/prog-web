/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bd.ConectaBD;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class InserirCidade extends HttpServlet {

    

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
        
        ArrayList<String> estados = new ArrayList<>();
        estados.add("---");
        estados.add("Paraná");
        estados.add("São Paulo");
        estados.add("Goiás");
        estados.add("Rio Grande do Sul");
        estados.add("Distrito Federal");
        
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
            out.println("<li><a href=\"CidadesA\">A</a></li>");
            out.println("<li><a href=\"CidadesB\">B</a></li>");
            out.println("<li><a href=\"CidadesC\">C</a></li>");
            out.println("<li class=\"active\"><a href=\"InserirCidade\">Inserir nova cidade</a></li>");
            out.println("</ul>");
            out.println("<br>");
            out.println("<form role=\"form\" method=\"POST\" action = \"InserirCidade\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"usr\">Nome da Cidade:</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"nomeCidade\" name =\"nomeCidade\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"usr\">Estado:</label>");
            out.println("<select multiple_name = \"sel_estado\" id = \"estado\"> name = \"estado\">");
            for(int i = 0; i<estados.size();i++)
                out.println("<option value = \""+i+"\">"+estados.get(i)+"</option>");
            out.println("</select>");
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
        String estado, nomeCidade;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        nomeCidade = request.getParameter("nomeCidade");
        estado = request.getParameter("estado");
        ConectaBD conexaoBD = new ConectaBD();
        Connection con = conexaoBD.conectaBD();
        PreparedStatement p;
        ResultSet rs;
        
        try{
            p = (PreparedStatement) con.prepareStatement("insert into cidades (nomeCidade, estadoCidade)values ("+nomeCidade+","+estado+");");
            rs = p.executeQuery();
        }catch(Exception ex){
            System.out.println("Erro: "+ex);
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cidade adicionada = "+nomeCidade+"</h1>");
        out.println("<h1>Cidade adicionada = "+estado+"</h1>");
        out.println("<a href=\"InserirCidade\"> Voltar </a>");
        out.println("</body>");
        out.println("</html>");

        System.out.println(nomeCidade);
        System.out.println(estado);
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
