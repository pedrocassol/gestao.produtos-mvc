<%--
  Created by IntelliJ IDEA.
  User: casso
  Date: 04/05/2026
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/produtos.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <title>Produtos</title>
</head>

<body>
<jsp:include page="/WEB-INF/pages/includes/header.jsp" />
<div class="page-wrapper">

    <c:choose>
        <c:when test="${param.msg == 'salvo'}">
            <div class="msg">Produto cadastrado!</div>
        </c:when>
        <c:when test="${param.msg == 'excluido'}">
            <div class="msg">Produto excluido!</div>
        </c:when>
        <c:when test="${param.msg == 'editado'}">
            <div class="msg">Produto atualizado!</div>
        </c:when>
    </c:choose>

    <div class="container">
    <div class="card">
        <h2>Cadastrar Produto</h2>
        <form action="produto" method="post">
            <input type="hidden" name="id" value="${produto.id}">

            <label>Nome</label>
            <input type="text" name="nome" value="${produto.nome}">

            <label>Descrição</label>
            <input type="text" name="descricao" value="${produto.descricao}">

            <label>Preço</label>
            <input type="number" step="0.01" name="preco" value="${produto.preco}">

            <label>Quantidade</label>
            <input type="number" name="quantidade" value="${produto.quantidade}">

            <button type="submit">
                ${produto.id != null ? 'Atualizar' : 'Cadastrar'}
            </button>
        </form>
    </div>
    <div class="card">
        <h2>Lista de Produtos</h2>
        <table>
            <tr>
                <th>#</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Quantidade</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="p" items="${produtos}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${p.id}</td>
                    <td>${p.nome}</td>
                    <td>${p.descricao}</td>
                    <td>${p.preco}</td>
                    <td>${p.quantidade}</td>
                    <td>
                        <a href="produto?acao=editar&id=${p.id}">Editar</a>
                        <a href="produto?acao=excluir&id=${p.id}" onclick="return confirm('Excluir?')">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</div>
<jsp:include page="/WEB-INF/pages/includes/footer.jsp" />
</body>
</html>
