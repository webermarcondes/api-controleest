package com.estoque.apicontroleestoque.mappers;

import com.estoque.apicontroleestoque.dto.LojaRequest;
import com.estoque.apicontroleestoque.dto.LojaResponse;
import com.estoque.apicontroleestoque.entidades.Estoque;
import com.estoque.apicontroleestoque.entidades.Loja;

import com.estoque.apicontroleestoque.mappers.EstoqueMapper;

import java.util.List;

public class LojaMapper {

    public static Loja LojaRequestToLoja(LojaRequest lojaRequest) {

        Loja out = new Loja();

        out.setId(lojaRequest.getId());
        out.setNome(lojaRequest.getNome());
        out.setCnpj(lojaRequest.getCnpj());
        out.setResponsavel(lojaRequest.getResponsavel());

        return out;
    }


    public static LojaResponse LojaToLojaResponse(Loja loja) {

       LojaResponse out = new LojaResponse();

       out.setCnpj(loja.getCnpj());
       out.setId(loja.getId());
       out.setNome(loja.getNome());
       out.setResponsavel(loja.getResponsavel());

       return out;
    }
}
