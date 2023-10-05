package com.cadastroee.persistence.dao;
import com.cadastroee.persistence.entities.Produto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.ejb.Local;
@Local
public interface ProdutoLocal {
    Produto criarProduto(String nome, BigDecimal preco);

    Produto buscarPorId(Long id);

    List<Produto> listarTodos();
}
