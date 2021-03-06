<%-- 
    Document   : inicial.jsp
    Created on : May 4, 2016, 3:00:00 PM
    Author     : fabio
--%>

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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <!-- Custom styles for this template -->
        <link href="../style/signin.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

            <form class="form-signin" role="form" action="../Login" method="POST">
                <h2 class="form-signin-heading">Login de usuário</h2>
                <label for="login" class="sr-only">Login</label>
                <input type="text" id="login" name="login" class="form-control" placeholder=" Digite o seu login: " required autofocus>
                <label for="inputPassword" class="sr-only">Senha: </label>
                <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Digite a sua senha" required>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            </form>

        </div>
    </body>
</html>
