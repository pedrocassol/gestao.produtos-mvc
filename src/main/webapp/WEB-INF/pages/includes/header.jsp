<%--
  Created by IntelliJ IDEA.
  User: casso
  Date: 04/05/2026
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">

<div class="header">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/images/productged-logo.png" alt="Logo img">
    </div>

    <div>
        <c:if test="${not empty sessionScope.usuario}">
            Olá, ${sessionScope.usuario.nome}! | <a href="logout">Sair</a>
        </c:if>
    </div>
</div>