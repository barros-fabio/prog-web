<%-- 
    Document   : consultarAluno
    Created on : May 10, 2016, 3:23:11 PM
    Author     : fabio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.ConectaBanco"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <meta name="description" content="TCC Manager">
        <meta name="author" content="Fabio Barros">
        <link rel="icon" href="../../favicon.ico">

        <title>TCC Manager</title>

        <!-- Bootstrap core CSS -->
        <link href="../style/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../style/navbar.css" rel="stylesheet">
        
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
        
        <style>
            #logout{
                border: none;
                background: none;
                margin-left: 5%;
   
            }
            
            #logout:hover{
                background: none;
            }
        </style>
        
    </head>

    <body>
        <%
            String nome = session.getAttribute("nomeUsuario").toString();
            
            ArrayList<String> cursos = new ArrayList<String>();
            
            
            cursos.add("Engenharia Elétrica");
            cursos.add("Engenharia Mecânica");
            cursos.add("Engenharia de Computação");
            cursos.add("Engenharia de Controle e Automação");
            cursos.add("Engenharia Eletrônica");
            cursos.add("Engenharia de Software");
        %>
        <div class="container">

            <!-- Barra de navegação estática -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="home.jsp">Home</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Alunos<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                  <li><a href="cadastrarAluno.jsp">Cadastrar</a></li>
                                  <li><a href="consultarAluno.jsp">Consultar</a></li> 
                                  <li><a href="escolherAluno.jsp">Alterar</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Trabalhos<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="cadastrarTrabalho.jsp">Cadastrar</a></li>
                                    <li><a href="consultarTrabalho.jsp">Consultar</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <%
                                    out.println("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">"+nome+"<span class=\"caret\"></span></a>");
                                %>
                                <ul class="dropdown-menu">
                                 
                                    <li>
                                        <form action="../Logout" method="POST">
                                            
                                            <button type="submit" class="btn btn-default" id="logout">Logout</button>
                                        </form>
                                    </li>
                                    
                                </ul>
                            </li>      
                        </ul>
                    </div>
                </div>
            </nav>

            <!-- Componente principal da página -->
            <div class="jumbotron"> 
                <h3>Consultar alunos</h3>
                <br>
                <form class="navbar-form" role="search" action="consultarAluno.jsp">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Consultar aluno pelo nome" name="q">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">Pesquisar</button>
                        </div>
                    </div>
                </form>
                <br>
                <%
                    ResultSet rs;
                    int id=0;
                    String pesquisa;
                    ConectaBanco db = new ConectaBanco();
                    Connection con = db.conectaBD();
                    
                    pesquisa = request.getParameter("q");
                %> 
                <div class="container">
                    <ul class="list-group">
                        <%
                    
                            rs = db.selectData(con,"SELECT nomeAluno FROM Aluno WHERE nomeAluno LIKE '"+pesquisa+"%'");
                            
                            while(rs.next()){
                                out.println("<li class=\"list-group-item\">"+rs.getString("nomeAluno")+"</li>");
                            }
                        %>
                    </ul>
                </div>
                
            </div>

        </div> 


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="../js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
