<%-- 
    Document   : alterPrice
    Created on : Jun 9, 2021, 8:32:47 PM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar preço</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
    </head>
    <body>
        <c:import url="/WEB-INF/view/adminHeader.jsp" />
        <form action="mvc?logic=SavePriceLogic&id=${price.fkProduct}" method="Post"
            style="margin: 2em 0">
            
            <div class="container">
                <div class="row">
                    <label for="price" class="form-label">Preço</label>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Kz</span>
                        <input type="text" class="form-control" placeholder="Alterar preço"
                               id="price" name="price" value="${price.price}">
                        <span class="input-group-text">.00</span>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-primary mb-3">Salvar</button>
                </div>
            </div>
        </form>
    </body>
</html>
