package com.estoque.apicontroleestoque.mappers;

import com.estoque.apicontroleestoque.dto.ProdutoRequest;
import com.estoque.apicontroleestoque.dto.ProdutoResponse;
import com.estoque.apicontroleestoque.entidades.Produto;

public class ProdutoMapper {

    public static Produto produtoRequestToProduto(ProdutoRequest produtoRequest) {

        Produto out = new Produto();

        out.setId(produtoRequest.getId());
        out.setNome(produtoRequest.getNome());
        out.setEan(produtoRequest.getEan());
        out.setDescricao(produtoRequest.getDescricao());

        return out;
    }

    public static ProdutoResponse produtoToProdutoResponse(Produto produto) {

        ProdutoResponse out = new ProdutoResponse();

        out.setNome(produto.getNome());
        out.setDescricao(produto.getDescricao());
        out.setEan(produto.getEan());
        out.setId(produto.getId());

        return out;
    }
}
