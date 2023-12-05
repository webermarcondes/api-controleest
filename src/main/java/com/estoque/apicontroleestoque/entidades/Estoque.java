package com.estoque.apicontroleestoque.entidades;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Optional;

@Entity(name="estoque")
public class Estoque {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="lojas_id")
    private Loja loja;

    @ManyToOne()
    @JoinColumn(name="produtos_id")
    private Produto produto;

    @Column
    private Integer qtde;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
