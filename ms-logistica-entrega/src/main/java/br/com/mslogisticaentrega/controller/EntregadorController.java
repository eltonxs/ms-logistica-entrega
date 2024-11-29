package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.integration.service.EntregadorService;
import br.com.mslogisticaentrega.domain.Entregador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @PostMapping
    public ResponseEntity<Entregador> criarEntregador(@RequestBody Entregador entregador) {
        Entregador novoEntregador = entregadorService.criarEntregador(entregador);
        return ResponseEntity.status(201).body(novoEntregador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> buscarEntregadorPorId(@PathVariable Long id) {
        Optional<Entregador> entregador = entregadorService.buscarPorId(id);
        return entregador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntregador(@PathVariable Long id) {
        entregadorService.deletarEntregador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Entregador>> listarEntregadores() {
        List<Entregador> entregadores = entregadorService.listarEntregadores();
        return ResponseEntity.ok(entregadores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEntregador(
            @PathVariable Long id,
            @RequestBody Entregador entregadorAtualizado) {
        entregadorService.atualizarEntregador(id, entregadorAtualizado);
        return ResponseEntity.noContent().build();
    }
}
