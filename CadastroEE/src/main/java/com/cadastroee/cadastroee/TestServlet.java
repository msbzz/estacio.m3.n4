package com.cadastroee.cadastroee;

import com.cadastroee.persistence.dao.ProdutoDao;
import com.cadastroee.persistence.entities.Produto;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        if (em == null) {
            message = "EntityManager não injetado!";
        } else {
            try {
                long userCount = em.createQuery("SELECT COUNT(p) FROM Produto p", Long.class).getSingleResult();
                message = "Total de produtos: " + userCount;

                /*
                List<Produto> produtos = produtoDao.listarTodos();

                resp.getWriter().write("Lista de Produtos:\n");
                for (Produto produto : produtos) {
                    resp.getWriter().write("ID: " + produto.getIdProduto() + ", Nome: " + produto.getNome() + "\n");
                }
                */


            } catch (Exception e) {
                message = "Erro ao consultar o banco: " + e.getMessage();
            }
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
