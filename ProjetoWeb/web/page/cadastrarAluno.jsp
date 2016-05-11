<%-- 
    Document   : cadastrarAluno
    Created on : May 10, 2016, 3:22:38 PM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
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
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Componente principal, onde está o form -->
            <div class="jumbotron">
                <h3>Cadastro de aluno: </h3>
                <br>
                <form>
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
                        <input type="text" class="form-control" id="ra" name="ra" placeholder="RA">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Curso: </label>
                        <input type="text" class="form-control" id="curso" name="curso" placeholder="Curso">
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="formGroupExampleInput2">Período: </label>
                        <input type="text" class="form-control" id="periodo" name="periodo" placeholder="Período">
                    </fieldset>
                    <button type="submit" class="btn btn-default">Cadastrar Aluno</button>                 
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
