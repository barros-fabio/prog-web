<%-- 
    Document   : consultarTrabalho
    Created on : May 10, 2016, 3:24:54 PM
    Author     : fabio
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>TCC Manager</title>

        <!-- Bootstrap core CSS -->
        <link href="../style/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../style/navbar.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
    </head>

    <body>
        <%
            String nome = session.getAttribute("nomeUsuario").toString();
        %>
        <div class="container">

          <!-- Static navbar -->
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
                                    <li><a href="perfil.jsp">Meu Perfil</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li>
                                        <form action="../Logout" method="POST">
                                            
                                            <button type="submit" class="btn btn-default">Logout</button>
                                        </form>
                                    </li>
                                    
                                </ul>
                            </li>     
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <h3>Consultar trabalhos</h3>
                <br>
                <form class="navbar-form" role="form" action="consultarTrabalho.jsp" method="GET">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Consultar trabalho" name="q">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">Pesquisar</button>
                        </div>
                    </div>
                    <br>
                    <div class="radio">
                        <label for="option1">TCC Defendido</label>
                        <input type="radio" id="option1" value="1" name="radAnswer">
                    </div>
                    <br>
                    <div class="radio">
                        <label for="option2">Meus TCCs</label>
                        <input type="radio" id="option2" value="2" name="radAnswer">
                    </div>
                    <br>
                    <div class="radio">
                        <label for="option3">TCC Geral</label>
                        <input type="radio" id="option3" value="3" name="radAnswer">
                    </div>
                </form>
                <br>
                <%
                    ResultSet rs;
                    int id=0;
                    String opcao= "1",pesquisa, profId;
                    ConectaBanco db = new ConectaBanco();
                    Connection con = db.conectaBD();
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    
                    
                %> 
                <div class="container">
                    <ul class="list-group">
                        <%  
                            if(request.getMethod().equals("GET")){
                        
                                opcao = request.getParameter("radAnswer");

                                if(request.getParameter("radAnswer")==null){
                                    System.out.println("Nada");
                                }else{
                                    pesquisa = request.getParameter("q");
                                    profId = session.getAttribute("orientador").toString();
                                    
                                    if(opcao.equals("1")){
                                        Date dataAtual = sdf.parse("18/05/2016");
                                        
                                        String dataAux;
                                        
                                        rs = db.selectData(con,"SELECT titulo, dataDefesa FROM TCC");
                                        
                                        while(rs.next()){
                                            dataAux = rs.getString("dataDefesa");
                                            Date dataDefesa = sdf.parse(dataAux);
                                            
                                            if(dataAtual.compareTo(dataDefesa)>0){
                                                System.out.println("Data Atual é depois de Data de Defesa, TCC Defendido");
                                                out.println("<li class=\"list-group-item\">"+rs.getString("titulo")+"</li>");
                                            }else if(dataAtual.compareTo(dataDefesa)<0){
                                                System.out.println("Data Atual é antes da Data de Defesa");
                                            }else if(dataAtual.compareTo(dataDefesa)==0){
                                                System.out.println("Data Atual é igual a Data de Defesa");
                                            }else{
                                                System.out.println("Indefinido");
                                            }
                                            
                                        }
                                            
                                            
                                        

                                    }else if(opcao.equals("2")){
                                        rs = db.selectData(con,"SELECT titulo FROM TCC WHERE orientador = "+profId+"");

                                        while(rs.next())
                                            out.println("<li class=\"list-group-item\">"+rs.getString("titulo")+"</li>");


                                    // Pesquisa por TCC Geral ( por nome)
                                    }else if(opcao.equals("3")){
                                        rs = db.selectData(con,"SELECT titulo FROM TCC WHERE titulo LIKE '"+pesquisa+"%'");

                                        while(rs.next())
                                            out.println("<li class=\"list-group-item\">"+rs.getString("titulo")+"</li>");

                                    }
                                }
                            }
                        %>
                    </ul>
                </div>
            </div>

        </div> <!-- /container -->


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

