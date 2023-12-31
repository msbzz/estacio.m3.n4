package com.estacio.cadastroee;

import java.io.IOException;
import java.math.BigDecimal;
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
                response.sendRedirect("ServletProdutoFC?acao=listar");
                return;

            case "alterar":
                Integer idAlterar = Integer.parseInt(request.getParameter("id"));
                Produto produtoAlterar = facade.find(idAlterar);
                produtoAlterar.setNome(request.getParameter("nome"));
                produtoAlterar.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produtoAlterar.setPrecoVenda(new BigDecimal(request.getParameter("precoVenda")));
                facade.edit(produtoAlterar);
                response.sendRedirect("ServletProdutoFC?acao=listar"); // PRG
                return;

            case "incluir":
                Produto produto = new Produto();
                produto.setNome(request.getParameter("nome"));
                produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produto.setPrecoVenda(new BigDecimal(request.getParameter("precoVenda")));
                facade.create(produto);
                response.sendRedirect("ServletProdutoFC?acao=listar"); // PRG
                return;

            default:
                break;
        }

        if (destino != null && !destino.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher(destino);
            rd.forward(request, response);
        }
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
