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
  <title>Lista de Produtos</title>
  <style>
    /* Adicione quaisquer estilos CSS necessários aqui */
    table {
      width: 100%;
      border-collapse: collapse;
    }
    table, th, td {
      border: 1px solid black;
    }
    th, td {
      padding: 8px;
      text-align: left;
    }
  </style>
</head>
<body>

<h1>Lista de Produtos</h1>

<!-- Link para incluir um novo produto -->
<a href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>

<table>
  <!-- Cabeçalho da tabela -->
  <thead>
  <tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Quantidade</th>
    <th>Preço de Venda</th>
    <th>Opções</th>
  </tr>
  </thead>

  <!-- Corpo da tabela -->
  <tbody>
  <!-- Loop para iterar sobre a lista de produtos e apresentar os dados na tabela -->
  <c:forEach var="produto" items="${produtos}">
    <tr>
      <td>${produto.idProduto}</td>
      <td>${produto.nome}</td>
      <td>${produto.quantidade}</td>
      <td>${produto.precoVenda}</td>
      <td>
        <a href="ServletProdutoFC?acao=formAlterar&id=${produto.idProduto}">Alterar</a> |
        <a href="ServletProdutoFC?acao=excluir&id=${produto.idProduto}">Excluir</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>