package com.estacio.cadastroee;
import java.util.List;

import com.estacio.persistence.entities.Produto;
import jakarta.ejb.Local;
@Local
public interface ProdutoFacadeLocal {

    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);

    List<Produto> findAll();

    // Outros métodos conforme necessário...

}

