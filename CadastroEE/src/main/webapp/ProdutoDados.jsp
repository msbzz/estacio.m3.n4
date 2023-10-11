<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Produto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container">

<h1><c:choose>
    <c:when test="${empty produto}">Incluir Produto</c:when>
    <c:otherwise>Alterar Produto</c:otherwise>
</c:choose></h1>

<form action="ServletProdutoFC" method="post" class="form">
    <c:if test="${not empty produto}">
        <input type="hidden" name="id" value="${produto.idProduto}" />
    </c:if>

    <div class="mb-3">
        <label for="nome" class="form-label">Nome:</label>
        <input type="text" id="nome" name="nome" value="${produto.nome}" class="form-control" required />
    </div>

    <div class="mb-3">
        <label for="quantidade" class="form-label">Quantidade:</label>
        <input type="number" id="quantidade" name="quantidade" value="${produto.quantidade}" class="form-control" required />
    </div>

    <div class="mb-3">
        <label for="precoVenda" class="form-label">Preço de Venda:</label>
        <input type="number" step="0.01" id="precoVenda" name="precoVenda" value="${produto.precoVenda}" class="form-control" required />
    </div>

    <div class="mb-3">
        <c:choose>
            <c:when test="${empty produto}">
                <input type="hidden" name="acao" value="incluir" />
                <input type="submit" value="Incluir" class="btn btn-primary" />
            </c:when>
            <c:otherwise>
                <input type="hidden" name="acao" value="alterar" />
                <input type="submit" value="Alterar" class="btn btn-primary" />
            </c:otherwise>
        </c:choose>
    </div>
</form>

</body>
</html>
