package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.integration.service.EntregaService;
import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.domain.StatusEntrega;
import br.com.mslogisticaentrega.domain.StatusRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public ResponseEntity<Entrega> criarEntrega(@Valid @RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaService.criarEntrega(entrega);
        return ResponseEntity.status(201).body(novaEntrega);
    }

    @GetMapping("/{id}/localizacao")
    public ResponseEntity<Map<String, Double>> obterLocalizacaoAtual(@PathVariable Long id) {
        Entrega entrega = entregaService.obterEntregaPorId(id);
        Map<String, Double> localizacao = new HashMap<>();
        localizacao.put("latitude", entrega.getLatitude());
        localizacao.put("longitude", entrega.getLongitude());
        return ResponseEntity.ok(localizacao);
    }

    @PutMapping("/{id}/localizacao")
    public ResponseEntity<Void> atualizarLocalizacao(
            @PathVariable Long id,
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        entregaService.atualizarLocalizacaoEntrega(id, latitude, longitude);
        return ResponseEntity.noContent().build();
    }


    // Método para atualizar o status da entrega
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestBody StatusRequest novoStatusRequest) {
        entregaService.atualizarStatus(id, StatusEntrega.valueOf(novoStatusRequest.getNovoStatus()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> listarEntregas() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return ResponseEntity.ok(entregas);
    }


}
