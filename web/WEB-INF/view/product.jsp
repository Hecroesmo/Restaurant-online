<%-- 
    Document   : product
    Created on : May 20, 2021, 10:20:56 PM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-pt">
    <head>
        <meta charset="utf-8">
        <title>Produtos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
        
        <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    </head>
    <body>
        <c:import url="/WEB-INF/view/adminHeader.jsp" />
        
        <form action="mvc?logic=SaveProductDetailsLogic" method="POST" style="margin: 2em 0">
            <div class="container-fluid">
                <h1 class="text-center">Controle de produtos</h1>
                <legend>Cadastre productos</legend>
                <div class="row" style="margin-bottom: 1em;">
                    <div class="col">
                        <label for="">1ª Categoria</label>
                        <select class="form-select" id="firstLevel"
                            name="productFirstCategory">
                        <option selected>Selecione ...</option>

                        <c:forEach var="product" items="${productDao.firstLevelList}">
                            <option value="${product.name}">${product.name}</option>
                        </c:forEach>
                        </select>
                    </div>

                    <div class="col">
                        <label for="">2ª Categoria</label>
                        <select class="form-select" id="secondLevel"
                            name="productSecondCategory">
                            <option selected>Selecione ...</option>
                        </select>
                    </div>

                    <div class="col">
                        <label for="">3ª Categoria</label>
                        <select class="form-select" id="thirdLevel"
                            name="productThirdCategory">
                            <option selected>Selecione ...</option>
                        </select>
                    </div>
                </div>

                <div class="row" style="margin-bottom: 1em;">
                    <div class="col">
                        <label for="fourLevel">Selecione o produto</label>
                        <select class="form-select" name="product" id="fourLevel">
                            <option selected>Selecione ...</option>
                        </select>
                    </div>
                </div>

                <div class="row bottom">
                    <div class="col">
                        <div class="mb-3">
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">Quantidade/Unidade</span>
                                <input type="text" class="form-control" name="quantity">
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Kz</span>
                            <input type="text" class="form-control" placeholder="preço" name="price">
                            <span class="input-group-text">.00</span>
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="formFile" class="form-label">Escolha imagem</label>
                    <input class="form-control" type="file" id="formFile" name="image">
                </div>
                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-primary mb-3">Salvar</button>
                    </div>
                </div>
            </div>
        </form>
        
        <div class="container-fluid" style="margin: 2em 0">
            <table class="table" id="table">
                <legend>Lista de productos</legend>
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Quantidade</th>
                    <th scope="col">Preço</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="detail" items="${details}">
                        <tr scope="row">
                            <td>${detail.fkProduct}</td>
                            <td>${productDao.getProductById(detail.fkProduct).getName()}</td>
                            <td>${detail.quantity}</td>
                            <td><a href="mvc?logic=AlterPriceLogic&id=${detail.fkProduct}"
                                >${priceDao.getPriceById(detail.fkProduct).price}</a></td>
                        </tr>
                    </c:forEach>                  
                        
                </tbody>
            </table>
        </div>
        <script src="<c:url value="/js/productsAjax.js" />"></script>
    </body>
</html>
