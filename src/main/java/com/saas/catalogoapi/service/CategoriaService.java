package com.saas.catalogoapi.service;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.exception.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private final List<CategoriaResponse> categorias = new ArrayList<>();
    private Long proximoId = 1L;

    public CategoriaService() {
        categorias.add(new CategoriaResponse(proximoId++, "Eletrônicos", "Produtos eletrônicos e gadgets"));
        categorias.add(new CategoriaResponse(proximoId++, "Periféricos", "Mouses, teclados, fones e afins"));
    }

    public List<CategoriaResponse> listarTodas() {
        return categorias;
    }

    public CategoriaResponse buscarPorId(Long id) {
        return categorias.stream()
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public CategoriaResponse criar(CategoriaRequest request) {
        CategoriaResponse novaCategoria = new CategoriaResponse(
                proximoId++,
                request.nome(),
                request.descricao()
        );
        categorias.add(novaCategoria);
        return novaCategoria;
    }
}
