<%-- 
    Document   : index.jsp
    Created on : May 12, 2021, 8:09:18 PM
    Author     : tio-hecro
--%>

<%@page import="ucan.edu.model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%Account account = (Account) session.getAttribute("account"); %>
        
        <c:if test="${account.username == \"root\" || account.username == \"admin\"}">
            <c:import url="/WEB-INF/view/adminHeader.jsp" />
        </c:if>
        <form>
            <input type="search" placeholder="Oque gostarias de comer?">
        </form>
    </body>
</html>
