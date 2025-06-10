package br.com.tryrun.corridas.controller;

import br.com.tryrun.corridas.dto.CorridaDto;
import br.com.tryrun.corridas.services.CorridaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private CorridaService service;

    @GetMapping
    public Page<CorridaDto> getCorridas(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterCorridas(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorridaDto> getCorridaById(@PathVariable("id") @NotNull Long id) {
        return ResponseEntity.ok(service.obterCorridaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CorridaDto> criarCorrida(@RequestBody @Valid CorridaDto dto, UriComponentsBuilder uriBuilder) {
        CorridaDto dtoCriado = service.criarCorrida(dto);
        URI endereco = uriBuilder.path("/corridas/{id}").buildAndExpand(dtoCriado.getId()).toUri();
        return ResponseEntity.created(endereco).body(dtoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorridaDto> atualizarCorrida(@PathVariable("id") @NotNull Long id, @RequestBody CorridaDto dto) {
        CorridaDto dtoAtualizado = service.atualizarCorrida(id, dto);
        return ResponseEntity.ok(dtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CorridaDto> excluirCorrida(@PathVariable("id") @NotNull Long id) {
        service.excluirCorrida(id);
        return ResponseEntity.noContent().build();
    }
}
