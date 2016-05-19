<%-- 
    Document   : alterarAluno
    Created on : May 18, 2016, 9:30:37 PM
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
        
        <script language="JavaScript">
            <!--
            function checker()
            {
                
                var regExpCPF = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})$/;

                var resultNome = document.formCadastroAluno.nome.value.toString();
                var resultCPF = document.formCadastroAluno.cpf.value.toString();
                var resultRA = document.formCadastroAluno.ra.value.toString();
                var resultCurso = document.formCadastroAluno.curso.value.toString();
                var resultPeriodo = document.formCadastroAluno.periodo.value.toString();
                var tamanhoNome = resultNome.length;
                var tamanhoCPF = resultCPF.length;
                var tamanhoRA = resultRA.length;
                var tamanhoPeriodo = resultPeriodo.length;
                var tamanhoCurso = resultCurso.length;
                //var resultDataEntrega = document.form1.dataEntrega.value.match(regExpDate);
                //var resultDataDefesa = document.form1.dataDefesa.value.match(regExpDate);
   
   
                alert(resultCurso);
                if(tamanhoNome==0){
                    alert("Preencha o campo nome!");
                    return false;
                }else if(tamanhoCPF == 0){
                    alert("Preencha o CPF!");
                    return false;
                }else if(tamanhoRA == 0){
                    alert("Preencha o RA!");
                    return false;
                }else if(resultCurso.equals("---")){
                    alert("Preencha o Curso!");
                    return false;
                }else if(tamanhoPeriodo == 0){
                    alert("Informe o período do aluno!");
                    return false;
                }else{
                    document.formCadastroAluno.submit();
                }
                
            }
            //-->
        </script>
        
    </head>

    <body>
        <%
            String nome = session.getAttribute("nomeUsuario").toString();
            
            // lista de cursos disponíveis no câmpus
            // Cada índice da lista corresponde a um curso.
            // 0 - Engenharia Elétrica, 1 - Engenharia Mecânica, 2 - Engenharia de Computação, 3 - Engenharia de Controle e Automação, 4 - Engenharia Eletrônica, 5 - Engenharia de Software
            // Da mesma forma, cada curso tem um número de períodos. Cada índice da lista de períodos corresponde ao curso de mesmo índice na lista de cursos
            ArrayList<String> cursos = new ArrayList<String>();
            
            
            cursos.add("Engenharia Elétrica");
            cursos.add("Engenharia Mecânica");
            cursos.add("Engenharia de Computação");
            cursos.add("Engenharia de Controle e Automação");
            cursos.add("Engenharia Eletrônica");
            cursos.add("Engenharia de Software");
    
        %>
        <div class="container">

          <!-- Barra de navegação estática-->
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

            <!-- Componente principal, onde está o form -->
            <div class="jumbotron">
                 <h3>Alterar aluno: </h3>
                
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
