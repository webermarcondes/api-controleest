package com.estoque.apicontroleestoque.repositorio;

import com.estoque.apicontroleestoque.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
