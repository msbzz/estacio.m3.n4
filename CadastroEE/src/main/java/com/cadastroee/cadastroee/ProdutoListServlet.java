package com.cadastroee.cadastroee;

import com.cadastroee.persistence.dao.ProdutoDao;
import com.cadastroee.persistence.entities.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarProdutos")
public class ProdutoListServlet extends HttpServlet {

    @EJB
    private ProdutoDao produtoDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Produto> produtos = produtoDao.listarTodos();

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<h1>Lista de Produtos:</h1>");
            for (Produto produto : produtos) {
                resp.getWriter().write("<p>ID: " + produto.getIdProduto() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPrecoVenda() + "</p>");
            }
        } catch (Exception e) {
            resp.getWriter().write("Erro ao listar produtos: " + e.getMessage());
        }
    }
}
