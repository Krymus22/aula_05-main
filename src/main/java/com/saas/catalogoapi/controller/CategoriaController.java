package com.saas.catalogoapi.controller;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarTodas() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> criar(@RequestBody CategoriaRequest request) {
        CategoriaResponse novaCategoria = categoriaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }
}
