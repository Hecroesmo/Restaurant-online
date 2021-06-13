<%-- 
    Document   : login
    Created on : May 12, 2021, 9:42:36 PM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
        
        <link rel="stylesheet" href="<c:url value="/css/signin.css"/>">
        
        <style>
        .bd-placeholder-img {
          font-size: 1.125rem;
          text-anchor: middle;
          -webkit-user-select: none;
          -moz-user-select: none;
          user-select: none;
        }

        @media (min-width: 768px) {
          .bd-placeholder-img-lg {
            font-size: 3.5rem;
          }
        }
    </style>
        </style>
    </head>
    <body class="text-center">
        <main class="form-signin">
            <form action="mvc?logic=AuthenticationLogic" method="post">
                <span class="mb-4" alt="logo">
                    <h1>~Appetito~</h1>
                </span>
                <h1 style="height: 10px"></h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" name="username">
                    <label for="floatingInput">Nome de usuário</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" name="password">
                    <label for="floatingPassword">Palavra passe</label>
                </div>
                <span style="color: red; display: block; margin: 1em 0">${error}</span>
                <div class="checkbox mb-3">
                  <label>
                    <input style="text-decoration: none" type="checkbox" value="remember-me">Lembrar
                  </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
            </form>
            <a href="mvc?logic=SignUpLogic">Não tem conta?</a>
        </main>
    </body>
</html>
