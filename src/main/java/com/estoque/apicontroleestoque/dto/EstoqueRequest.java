package com.estoque.apicontroleestoque.dto;

import com.estoque.apicontroleestoque.entidades.Loja;

public class EstoqueRequest {

    //não tem id;

    private LojaRequest lojaRequest;

    private ProdutoRequest produtoRequest;

    private Integer qtde;

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public LojaRequest getLojaRequest() {
        return lojaRequest;
    }

    public void setLojaRequest(LojaRequest lojaRequest) {
        this.lojaRequest = lojaRequest;
    }

    public ProdutoRequest getProdutoRequest() {
        return produtoRequest;
    }

    public void setProdutoRequest(ProdutoRequest produtoRequest) {
        this.produtoRequest = produtoRequest;
    }
}
