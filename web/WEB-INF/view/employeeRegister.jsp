<%-- 
    Document   : signup
    Created on : May 13, 2021, 9:37:36 AM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset=UTF-8">
        <title>Empregado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
        
        <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    </head>
    <body>
        <c:import url="/WEB-INF/view/adminHeader.jsp" />
        <div class="container">
            <main style="padding-bottom: 3em">
                <div class="py-5 text-center">
                    <span class="d-block mx-auto mb-4"><h1>Controle de Funcionários</h1></span>
                </div>
                <form action="mvc?logic=SaveEmployeeLogic" method="POST">
                    <legend>Cadastrar novo Funcionário</legend>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="col">
                            <input type="text" class="form-control"
                                placeholder="Nome" name="firstName">
                        </div>
                        <div class="col">
                            <input type="text" class="form-control"
                                placeholder="Apelido" name="lastName">
                        </div>
                        <div class="col form-floating">
                            <input type="date" class="form-control" id="bdate"
                                placeholder="data de nascimento" name="birthDate">
                            <label for="bdate">Data de nascimento</label>
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="input-group mb-3 col">
                            <span class="input-group-text">@</span>
                            <input type="text" class="form-control"
                                placeholder="Email" name="email">
                        </div>
                        <div class="input-group mb-3 col">
                            <span class="input-group-text" id="basic-addon1">Tel</span>
                            <input type="tel" class="form-control"
                                placeholder="Telefone" name="phoneNumber" >
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="input-group mb-3 col">
                            <span class="input-group-text" 
                                id="basic-addon1">Segurança Social</span>
                            <input type="text" class="form-control"
                                placeholder="Entre com o número de segurança social"
                                name="socialSecurityNumber">
                        </div>
                        <div class="input-group mb-3 col">
                            <span class="input-group-text" 
                                id="basic-addon1">B.I</span>
                                
                            <input type="text" class="form-control"
                                placeholder="Entre com o número do bilhete de identidade"
                                name="identifyCardNumber">
                        </div>
                        <div class="input-group mb-3 col">
                            <span class="input-group-text" id="basic-addon1">Salário</span>
                            <input type="tel" class="form-control"
                                placeholder=".00" name="salary" >
                            <span class="input-group-text" id="basic-addon1">Kz</span>
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="input-group mb-3 col">
                            <span class="input-group-text">Nome de usuário</span>
                            <input type="text" class="form-control"
                                placeholder="Nome de usuário" name="username">
                        </div>
                        <div class="input-group mb-3 col">
                            <span class="input-group-text" id="basic-addon1">Palavra passe</span>
                            <input type="password" class="form-control"
                                placeholder="Entre com a palavra passe" name="password" >
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="col">
                            <label for="firstLevel">País</label>
                            <select class="form-select" name="country" id="firstLevel">
                                <option selected>Selecione ...</option>
                                <c:forEach var="country" items="${countries}">
                                    <option value="${country.name}">${country.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col">
                            <label for="secondLevel">Provincia</label>
                            <select class="form-select" name="province" id="secondLevel">
                                <option selected>Selecione ...</option>
                            </select>
                        </div>
                        <div class="col">
                            <label for="thirdLevel">Munícipe</label>
                            <select class="form-select" name="municipality" id="thirdLevel">
                                <option selected>Selecione ...</option>
                            </select>
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="col">
                            <label for="fourLevel">Districto/Comuna</label>
                            <select class="form-select" name="commune" id="fourLevel">
                                <option selected>Selecione ...</option>
                            </select>
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="col form-floating">
                            <input type="text" class="form-control" id="neighborhood"
                                placeholder="d" name="neighborhood">
                            <label for="neighborhood">Bairro</label>
                        </div>
                        <div class="col form-floating">
                            <input type="text" class="form-control" id="road"
                                placeholder="Rua" name="road">
                            <label for="road">Rua</label>
                        </div>
                        <div class="col form-floating">
                            <input type="text" class="form-control" id="houseNumber"
                                placeholder="d" name="houseNumber">
                            <label for="houseNumber">Número de casa</label>
                        </div>
                    </div>
                    <button class="w-100 btn btn-primary btn-lg" type="submit">Salvar</button>
                </form>
            </main>
        </div>
        <script src="<c:url value="/js/regionAjax.js" />"></script>
    </body>
</html>
