package com.estoque.apicontroleestoque.mappers;

import com.estoque.apicontroleestoque.dto.EstoqueRequest;
import com.estoque.apicontroleestoque.dto.EstoqueResponse;
import com.estoque.apicontroleestoque.entidades.Estoque;
import com.estoque.apicontroleestoque.entidades.Loja;
import com.estoque.apicontroleestoque.entidades.Produto;
import com.estoque.apicontroleestoque.repositorio.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EstoqueMapper {

    public static Estoque EstoqueRequestToEstoque(EstoqueRequest estoqueRequest) {

        Loja loja = LojaMapper.LojaRequestToLoja(estoqueRequest.getLojaRequest());
        Produto produto = ProdutoMapper.produtoRequestToProduto(estoqueRequest.getProdutoRequest());

        Estoque out = new Estoque();

        out.setQtde(estoqueRequest.getQtde());
        out.setLoja(loja);
        out.setProduto(produto);

        return out;
    }

    public static EstoqueResponse EstoqueToEstoqueResponse(Estoque estoque) {
        EstoqueResponse out = new EstoqueResponse();

        out.setId(estoque.getId());
        out.setQtde(estoque.getQtde());
        out.setLojaId(estoque.getLoja().getId());
        out.setProdutoId(estoque.getProduto().getId());

        return out;
    }
}
