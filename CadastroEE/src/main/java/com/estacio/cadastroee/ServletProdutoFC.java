package com.estacio.cadastroee;
import java.io.IOException;

import com.estacio.persistence.entities.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.ejb.EJB;
@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "";

        if (acao == null || acao.isEmpty()) {
            acao = "listar";
        }
        switch (acao) {
            case "listar":
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "formIncluir":
            case "formAlterar":
                destino = "ProdutoDados.jsp";
                if (acao.equals("formAlterar")) {
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("produto", facade.find(id));
                }
                break;

            case "excluir":
                Integer idExcluir = Integer.parseInt(request.getParameter("id"));
                facade.remove(facade.find(idExcluir));
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "alterar":
                Long idAlterar = Long.parseLong(request.getParameter("id"));
                Produto produtoAlterar = facade.find(idAlterar);
                // Preencha o produtoAlterar com os demais campos do request aqui
                facade.edit(produtoAlterar);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "incluir":
                Produto produto = new Produto();
                // Preencha o produto com os campos do request aqui
                facade.create(produto);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            default:
                // Trate outras ações se necessário ou configure uma mensagem de erro
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet Produto Front Controller";
    }
}
