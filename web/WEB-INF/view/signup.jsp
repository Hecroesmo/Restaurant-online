<%-- 
    Document   : signup
    Created on : May 13, 2021, 9:37:36 AM
    Author     : tio-hecro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrever-se</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
            rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <main>
                <div class="py-5 text-center">
                    <span class="d-block mx-auto mb-4"><h1>~Appetito~</h1></span>
                    <!--    <p class="lead">Seja bem vindo ao <strong>~Appetito~</strong>, a loja virtual que te permite encomendar os seus pratos favoritos.</p>   -->
                </div>
                <form>
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
                        <div class="col">
                            <select class="form-select" name="country">
                                <option selected>País</option>
                                <option value="1">One</option>
                            </select>
                        </div>
                        <div class="col">
                            <select class="form-select" name="province">
                                <option selected>Provincia</option>
                                <option value="1">One</option>
                            </select>
                        </div>
                        <div class="col">
                            <select class="form-select" name="municipality">
                                <option selected>Munícipe</option>
                                <option value="1">One</option>
                            </select>
                        </div>
                    </div>
                    <div class="row g-3" style="padding-bottom: 1em">
                        <div class="col form-floating">
                            <input type="text" class="form-control" id="district"
                                placeholder="d" name="district">
                            <label for="district">Districto/Bairro</label>
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
            

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; 2017–2021 ~Appetito~</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacy</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Support</a></li>
            </ul>
        </footer>
    </body>
</html>
