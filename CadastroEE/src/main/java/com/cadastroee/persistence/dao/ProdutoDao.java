package com.cadastroee.persistence.dao;

import com.cadastroee.persistence.entities.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;
@Stateless
public class ProdutoDao {

    @PersistenceContext
    private EntityManager em;


    public Produto criarProduto(String nome, BigDecimal preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPrecoVenda(preco);
        em.persist(produto);
        return produto;
    }

     public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

     public List<Produto> listarTodos() {
        //return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();

        TypedQuery<Produto> query= em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }

}
