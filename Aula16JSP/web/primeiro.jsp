<%-- 
    Document   : primeiro
    Created on : May 3, 2016, 2:14:36 PM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página JSP</title>
    </head>
    <body>
        <form role = "form" action = "./segundo.jsp" method ="POST" accept-charset="utf-8">
            <label for="nome"> Nome: </label>
            <input type="text" name="nome" value="" id="name">
            <input type ="submit" name="enviar" value="enviar">
            
        </form>
        
    </body>
</html>
