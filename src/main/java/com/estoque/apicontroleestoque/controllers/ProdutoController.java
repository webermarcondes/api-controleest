package com.estoque.apicontroleestoque.controllers;

import com.estoque.apicontroleestoque.dto.ProdutoRequest;
import com.estoque.apicontroleestoque.dto.ProdutoResponse;
import com.estoque.apicontroleestoque.entidades.Produto;
import com.estoque.apicontroleestoque.mappers.ProdutoMapper;
import com.estoque.apicontroleestoque.repositorio.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/")
    @CrossOrigin
    public ResponseEntity<List<ProdutoResponse>> carregarProduto() {


        List<Produto> retorno = repository.findAll();

        List<ProdutoResponse> out = retorno.stream()
                .map(ProdutoMapper::produtoToProdutoResponse)
                .toList();

        return ResponseEntity.ok().body(out);
    }


    @PostMapping("/")
    @CrossOrigin
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutoRequest produtoRequest) {

        Produto retorno = repository.save(ProdutoMapper.produtoRequestToProduto(produtoRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.produtoToProdutoResponse(retorno));
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ProdutoResponse> editarProduto(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        Produto produtoNovo = ProdutoMapper.produtoRequestToProduto(produtoRequest);

        Produto retorno = repository.findById(id).map(record -> {

            record.setDescricao(produtoNovo.getDescricao());
            record.setEan(produtoNovo.getEan());
            record.setNome(produtoNovo.getNome());

            return repository.save(record);
        }).get();


        return ResponseEntity.ok().body(ProdutoMapper.produtoToProdutoResponse(retorno));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin()
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok(null);
    }
}
