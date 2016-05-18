<%-- 
    Document   : cadastrarTrabalho
    Created on : May 10, 2016, 3:24:37 PM
    Author     : fabio
--%>

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
        
        
        
        <SCRIPT LANGUAGE="JavaScript">
            <!--
            function checker()
            {
                
                var regExpDate = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
               
                var resultDataEntrega = document.form1.dataEntrega.value.match(regExpDate);
                var resultDataDefesa = document.form1.dataDefesa.value.match(regExpDate);
                var resultTitulo = document.form1.titulo.value.toString();
                var resultNota = document.form1.nota.value.toString();
                var n = resultTitulo.length;
                var grade = parseFloat(resultNota);
   
                if(n==0){
                    alert("Preencha o campo nome!");
                    return false;
                }else if(resultDataEntrega == null){
                    alert("Data de entrega invalida!");
                    document.form1.dataEntrega.value = "";
                    return false;
                }else if(resultDataDefesa == null){
                    alert("Data de defesa inválida!");
                    document.form1.dataEntrega.value = "";
                    return false;
                }else if(grade>10.0){
                    alert("Nota inválida!");
                    return false;
                }else if(grade<0.0){
                    alert("Nota inválida!");
                    return false;
                }else{
                    document.form1.submit();
                }
                
            }
            //-->
        </SCRIPT>
        
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
                <h3>Cadastrar trabalho de conclusão de curso:</h3>
                <br>
                <%
                    
                    request.getSession().setAttribute("orientador",session.getAttribute("orientador"));
                    
                %>
                <form name="form1" role="form" action="../CadastrarTrabalho" method="POST" onsubmit="return checker()">
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput">Título: </label>
                        <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Título do trabalho">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exampleTextarea">Resumo: </label>
                        <textarea class="form-control" id="resumo" name="resumo" rows="5" placeholder="Digite aqui um resumo do trabalho"></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Aluno: </label>
                        <input type="text" class="form-control" id="aluno" name="aluno" placeholder="Aluno (autor)">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Data de entrega: </label>
                        <input type="text" class="form-control" id="dataEntrega" name="dataEntrega" placeholder="Data de entrega DD/MM/AAAA">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Data de defesa: </label>
                        <input type="text" class="form-control" id="dataDefesa" name="dataDefesa" placeholder="Data de defesa DD/MM/AAAA">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Nota: </label>
                        <input type="text" class="form-control" id="nota" name="nota" placeholder="Nota">
                    </fieldset>
                    <button type="submit" class="btn btn-default">Cadastrar Trabalho</button>
                </form>
                
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
