<%-- 
    Document   : inserirCidade
    Created on : 03/05/2016, 22:15:01
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
        <li><a href="cidadesA.jsp">A</a></li>
        <li><a href="cidadesB.jsp">B</a></li>
        <li><a href="cidadesC.jsp">C</a></li>
        <li class="active"><a href="inserirCidade.jsp">Inserir nova cidade</a></li>
    </ul>
    <br>
    
    
    
    <form role="form" method="POST" action = "inserirCidade.jsp">
        <div class="form-group">
            <label for="usr">Nome da Cidade:</label>
            <input type="text" class="form-control" id="nomeCidade" name ="nomeCidade">
        </div>
        
        <div class="form-group">
            <label for="usr">Estado:</label>
            <select multiple_name = "sel_estado" id = "estado" name ="estado">
           
            <% 
                
                
                ArrayList<String> estados = new ArrayList<String>();
                estados.add("---");
                estados.add("Paraná");
                estados.add("São Paulo");
                estados.add("Goiás");
                estados.add("Rio Grande do Sul");
                estados.add("Distrito Federal");

                for(int i = 0; i<estados.size();i++)
                    out.println("<option value = "+i+">"+estados.get(i)+"</option>");
                
                if(request.getMethod().equals("POST")){
                    ConectaBanco db = new ConectaBanco();
                    Connection c = db.conectaBD();
            
                    db.insertData(c,"INSERT INTO cidades(nome,estado) VALUES (?,?)", request.getParameter("nomeCidade"),request.getParameter("estado"));
                }
            %>
            </select>
        </div>
        <button type = "submit"> Enviar </button>
    </form>
    
</div>
       
<jsp:include page = "footer.jsp">
    <jsp:param name ="foot" value="footerPage"/>
</jsp:include>
