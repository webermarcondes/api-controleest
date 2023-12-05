package com.estoque.apicontroleestoque.controllers;

import com.estoque.apicontroleestoque.dto.LojaRequest;
import com.estoque.apicontroleestoque.dto.LojaResponse;
import com.estoque.apicontroleestoque.dto.ProdutoResponse;
import com.estoque.apicontroleestoque.entidades.Loja;
import com.estoque.apicontroleestoque.mappers.LojaMapper;
import com.estoque.apicontroleestoque.mappers.ProdutoMapper;
import com.estoque.apicontroleestoque.repositorio.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    LojaRepository repository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<LojaResponse>> carregarLoja() {
        List<Loja> retorno = repository.findAll();

        List<LojaResponse> out = retorno.stream()
                .map(LojaMapper::LojaToLojaResponse)
                .toList();

        return ResponseEntity.ok().body(out);
    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<LojaResponse> criarLoja(@RequestBody LojaRequest lojaRequest) {

        Loja retorno = repository.save(LojaMapper.LojaRequestToLoja(lojaRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(LojaMapper.LojaToLojaResponse(retorno));
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<LojaResponse> editarLoja(@PathVariable Long id, @RequestBody LojaRequest lojaRequest) {

        Loja lojaNovo = LojaMapper.LojaRequestToLoja(lojaRequest);

        Loja retorno = repository.findById(id).map(record -> {


            record.setNome(lojaNovo.getNome());
            record.setCnpj(lojaNovo.getCnpj());
            record.setResponsavel(lojaNovo.getResponsavel());

            return repository.save(record);

        }).get();


        return ResponseEntity.ok().body(LojaMapper.LojaToLojaResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> excluirLoja(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok(null);
    }
}
