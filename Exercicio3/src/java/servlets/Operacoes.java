/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
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
public class Operacoes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        String op;
        ArrayList<Integer> numbers = new ArrayList<>();
        Random generator = new Random();
        Random generator2 = new Random();
        int n1, n2;
        
        //Preenchendo ArrayList com numeros aleatorios
        for(int i = 0; i<10; i++){
            int num = generator.nextInt(1000);
            numbers.add(num);
        }
        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Operações</title>");    
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
        out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");     
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h3>Operações</h3>");
        out.println("<br>");
        out.println("<ul class=\"list-group\">");
        op = request.getParameter("op"); // atribui a uma variavel o parametro passado
        // escolhe dois numeros aleatorios no arrayList
        n1 = numbers.get(generator.nextInt(9));
        n2 = numbers.get(generator2.nextInt(9));
        
        // Operaçao para verificar se um numero eh menor do que outro
        if(op.equals("menor")){
            if(n1<n2){
                out.println("<li class=\"list-group-item\"> O número "+n1+" é menor que "+n2+"</li>");
            }else{
                out.println("<li class=\"list-group-item\"> O número "+n2+" é menor que "+n1+"</li>");
            }
        // Operaçao para verificar se um numero eh maior do que o outro
        }else if(op.equals("maior")){
            if(n1>n2){
                out.println("<li class=\"list-group-item\"> O número "+n1+" é maior que "+n2+"</li>");
            }else{
                out.println("<li class=\"list-group-item\"> O número "+n2+" é maior que "+n1+"</li>");
            }
        // Operacao para verificar a media aritimetica de dois numeros
        }else if(op.equals("media")){
            out.println("<li class=\"list-group-item\"> A média aritimética entre o número "+n1+" e o número "+n2+" é "+(n1+n2)/2+"</li>");
        }
        
       
        out.println("</ul>");
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
