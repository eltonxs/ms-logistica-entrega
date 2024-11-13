package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.model.Entrega;
import br.com.mslogisticaentrega.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @PutMapping("/{id}/localizacao")
    public ResponseEntity<String> atualizarLocalizacaoEntrega(
            @PathVariable Long id,
            @RequestParam Double latitude,
            @RequestParam Double longitude) {
        entregaService.atualizarLocalizacaoEntrega(id, latitude, longitude);
        return ResponseEntity.ok("Localização atualizada com sucesso!");
    }

    @GetMapping("/{id}/localizacao")
    public ResponseEntity<Map<String, Double>> obterLocalizacaoAtualEntrega(@PathVariable Long id) {
        Entrega entrega = entregaService.obterEntregaPorId(id);
        Map<String, Double> localizacao = new HashMap<>();
        localizacao.put("latitude", entrega.getLatitude());
        localizacao.put("longitude", entrega.getLongitude());
        return ResponseEntity.ok(localizacao);
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> listarEntregas() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return ResponseEntity.ok(entregas);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
