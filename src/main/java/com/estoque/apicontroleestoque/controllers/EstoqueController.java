package com.estoque.apicontroleestoque.controllers;


import com.estoque.apicontroleestoque.dto.EstoqueRequest;
import com.estoque.apicontroleestoque.dto.EstoqueResponse;
import com.estoque.apicontroleestoque.entidades.Estoque;
import com.estoque.apicontroleestoque.entidades.Loja;
import com.estoque.apicontroleestoque.mappers.EstoqueMapper;
import com.estoque.apicontroleestoque.repositorio.EstoqueRepository;
import com.estoque.apicontroleestoque.repositorio.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueRepository repository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<EstoqueResponse>> carregarEstoque() {
        List<Estoque> retorno = repository.findAll();

        List<EstoqueResponse> out = retorno.stream()
                .map(EstoqueMapper::EstoqueToEstoqueResponse)
                .toList();

        return ResponseEntity.ok().body(out);

    }

    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<EstoqueResponse> criarEstoque(@RequestBody EstoqueRequest estoqueRequest) {

        Estoque retorno = repository.save(EstoqueMapper.EstoqueRequestToEstoque(estoqueRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(EstoqueMapper.EstoqueToEstoqueResponse(retorno));
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EstoqueResponse> editarEstoque(@PathVariable Long id, @RequestBody EstoqueRequest estoqueRequest) {

        Estoque estoqueNovo = EstoqueMapper.EstoqueRequestToEstoque(estoqueRequest);

        Estoque retorno = repository.findById(id).map(record -> {

            record.setQtde(estoqueNovo.getQtde());

            return repository.save(record);
        }).get();

        return ResponseEntity.ok().body(EstoqueMapper.EstoqueToEstoqueResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> excluirEstoque(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok(null);
    }


}
