package com.cadastroee.cadastroee;

import com.cadastroee.persistence.entities.Produto;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class ProdutoFacade implements ProdutoFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void edit(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        em.remove(em.merge(produto));
    }

    @Override
    public Produto find(Object id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> findAll() {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }

    // Caso tenha outros métodos, você pode implementá-los aqui
}
