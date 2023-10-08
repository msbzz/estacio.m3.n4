<%--
  Created by IntelliJ IDEA.
  User: mim
  Date: 07/10/2023
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Produto</title>
</head>
<body>

<h1><c:choose>
    <c:when test="${empty produto}">Incluir Produto</c:when>
    <c:otherwise>Alterar Produto</c:otherwise>
</c:choose></h1>

<form action="ServletProdutoFC" method="post">
    <c:if test="${not empty produto}">
        <input type="hidden" name="id" value="${produto.idProduto}" />
    </c:if>

    <div>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${produto.nome}" required />
    </div>

    <div>
        <label for="quantidade">Quantidade:</label>
        <input type="number" id="quantidade" name="quantidade" value="${produto.quantidade}" required />
    </div>

    <div>
        <label for="precoVenda">Preço de Venda:</label>
        <input type="number" step="0.01" id="precoVenda" name="precoVenda" value="${produto.precoVenda}" required />
    </div>

    <div>
        <c:choose>
            <c:when test="${empty produto}">
                <input type="hidden" name="acao" value="incluir" />
                <input type="submit" value="Incluir" />
            </c:when>
            <c:otherwise>
                <input type="hidden" name="acao" value="alterar" />
                <input type="submit" value="Alterar" />
            </c:otherwise>
        </c:choose>
    </div>
</form>

</body>
</html>
