package com.estoque.apicontroleestoque.repositorio;

import com.estoque.apicontroleestoque.entidades.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
