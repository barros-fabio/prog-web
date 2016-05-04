<%-- 
    Document   : cidadesC
    Created on : 03/05/2016, 22:14:31
    Author     : Fabio Barros
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="bd.ConectaBanco"%>
<jsp:include page = "header.jsp">
    <jsp:param name ="title" value="header"/>
</jsp:include>

<div class="container">
    <h3>Lista de Cidades</h3>
    <ul class="nav nav-tabs nav-justified">
        <li class="active"><a href="cidadesA.jsp">A</a></li>
        <li><a href="cidadesB.jsp">B</a></li>
        <li class="active"><a href="cidadesC.jsp">C</a></li>
        <li><a href="inserirCidade.jsp">Inserir nova cidade</a></li>
    </ul>
    <br>

    <ul class="list-group">
        <%
            ArrayList<String> cidades;
            ConectaBanco db = new ConectaBanco();
            Connection c = db.conectaBD();
            
            cidades = db.selectData(c,"Select * from cidades where nome like 'C%'");
            
            for(int i=0; i<cidades.size();i++)    
                out.println("<li class=\"list-group-item\">"+cidades.get(i)+"</li>");
        %>
    </ul>
</div>
       
<jsp:include page = "footer.jsp">
    <jsp:param name ="foot" value="footerPage"/>
</jsp:include>
