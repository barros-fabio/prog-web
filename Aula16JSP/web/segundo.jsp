<%-- 
    Document   : segundo.jsp
    Created on : May 3, 2016, 2:14:55 PM
    Author     : fabio
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%   
            if(request.getMethod().equals("POST")){
                out.println("<h1>"+request.getParameter("nome")+"</h1>");
            }         
        %>
    </body>
</html>
