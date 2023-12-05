package com.estoque.apicontroleestoque.repositorio;

import com.estoque.apicontroleestoque.entidades.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
