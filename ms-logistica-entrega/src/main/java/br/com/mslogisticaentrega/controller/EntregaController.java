package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.model.Entrega;
import br.com.mslogisticaentrega.model.StatusEntrega;
import br.com.mslogisticaentrega.model.StatusRequest;
import br.com.mslogisticaentrega.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public ResponseEntity<Entrega> criarEntrega(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaService.criarEntrega(entrega);
        return ResponseEntity.status(201).body(novaEntrega);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Entrega> atualizarStatus(
            @PathVariable Long id,
            @RequestBody StatusRequest statusRequest) {
        StatusEntrega status = StatusEntrega.valueOf(statusRequest.getNovoStatus().toUpperCase());
        Entrega entregaAtualizada = entregaService.atualizarStatus(id, status);
        return ResponseEntity.ok(entregaAtualizada);
    }



    @GetMapping
    public ResponseEntity<List<Entrega>> listarEntregas() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return ResponseEntity.ok(entregas);
    }
}
