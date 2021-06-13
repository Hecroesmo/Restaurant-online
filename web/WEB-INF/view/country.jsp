<%-- 
    Document   : region
    Created on : Jun 3, 2021, 6:03:17 PM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>País</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <form action="mvc?logic=SaveCountryLogic" method="POST">
                <div class="mb-3">
                    <label for="country" class="form-label">País</label>
                    <input class="form-control" placeholder="Entre com o país"
                        type="text" id="country" name="country">
                </div>
                <button type="submit" class="btn btn-primary mb-3">Salvar</button>
            </form>
        </div>
    </body>
</html>
