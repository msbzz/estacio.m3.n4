
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista de Produtos</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container">

<h1>Lista de Produtos</h1>

<!-- Link para incluir um novo produto -->
<a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Novo Produto</a>

<table class="table table-striped">
  <!-- Cabeçalho da tabela -->
  <thead class="table-dark">
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
        <a href="ServletProdutoFC?acao=formAlterar&id=${produto.idProduto}" class="btn btn-primary btn-sm">Alterar</a>
        <a href="ServletProdutoFC?acao=excluir&id=${produto.idProduto}" class="btn btn-danger btn-sm">Excluir</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
