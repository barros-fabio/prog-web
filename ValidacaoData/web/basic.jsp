<%-- 
    Document   : basic.jsp
    Created on : May 17, 2016, 2:54:12 PM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <TITLE>Reading Verified Data</TITLE>
  </HEAD>

    <BODY>
        <H1>Reading Verified Data</H1>
        That date is 
        <% out.println(request.getParameter("text1")); %>
   </BODY>
</HTML>