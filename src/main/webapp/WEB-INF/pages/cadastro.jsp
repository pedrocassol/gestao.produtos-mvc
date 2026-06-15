<%--
  Created by IntelliJ IDEA.
  User: casso
  Date: 04/05/2026
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/cadastro.css">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/footer.css">

    <title>Cadastro</title>
</head>

<body>

<jsp:include page="/WEB-INF/pages/includes/header.jsp" />

<div class="page-center">
    <div class="box">

        <h2>Criar conta</h2>

        <form action="usuario" method="post">
            <input type="text" name="nome" placeholder="Nome" required>

            <input type="email" name="email" placeholder="E-mail" required>

            <input type="password" name="senha" placeholder="Senha" required>

            <button type="submit">Cadastrar</button>
        </form>

        <a href="index.jsp">Voltar</a>

    </div>
</div>

<jsp:include page="/WEB-INF/pages/includes/footer.jsp" />

</body>
</html>