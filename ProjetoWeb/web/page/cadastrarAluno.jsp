<%-- 
    Document   : cadastrarAluno
    Created on : May 10, 2016, 3:22:38 PM
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
        
        <script language="JavaScript"> // Código Javascript para validação de dados
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

            <!-- Componente principal, onde está o form -->
            <div class="jumbotron">
                <h3>Cadastro de aluno: </h3>
                <br>
                <%
                    
                    request.getSession().setAttribute("orientador",session.getAttribute("orientador"));
                    
                %>
                <form name="formCadastroAluno" role="form" action="../CadastrarAluno" method="POST" onsubmit="return checker()">
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput">Nome: </label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">CPF: </label>
                        <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">RA: </label>
                        <input type="text" class="form-control" id="ra" name="ra" placeholder="RA (Código do Aluno)">
                    </fieldset>
                    <fieldset class="form-group">
                        <div class="form-group">
                            <label for="sel1">Curso:</label>
                            <select class="form-control" id="curso" name="curso">
                                <%      
                                    out.println("<option value\"---\"> --- </option>");   
                                    for(int i=0;i<cursos.size();i++){
                                        out.println("<option value=\""+i+"\">"+cursos.get(i).toString()+"</option>");
                                    }                                
                                %>
                               
                            </select>
                        </div>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Período: </label>
                        <input type="text" class="form-control" id="periodo" name="periodo" placeholder="Período">
                    </fieldset>
                    <button type="submit" class="btn btn-default">Cadastrar Aluno</button>                 
                </form>
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
