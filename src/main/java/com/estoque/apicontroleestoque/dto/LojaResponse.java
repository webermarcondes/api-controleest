package com.estoque.apicontroleestoque.dto;

import com.estoque.apicontroleestoque.entidades.Estoque;

import java.util.List;

public class LojaResponse {

    //Tem id;

    private Long id;
    private String nome;

    private String cnpj;

    private String responsavel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
