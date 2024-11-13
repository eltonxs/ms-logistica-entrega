package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.model.Entregador;
import br.com.mslogisticaentrega.service.EntregadorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @PostMapping
    public ResponseEntity<Entregador> criarEntregador(@Valid @RequestBody Entregador entregador) {
        Entregador novoEntregador = entregadorService.criarEntregador(entregador);
        return ResponseEntity.status(201).body(novoEntregador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEntregador(
            @PathVariable Long id,
            @Valid @RequestBody Entregador entregador) {

        return entregadorService.atualizarEntregador(id, entregador)
                .map(entregadorAtualizado -> ResponseEntity.ok(entregadorAtualizado))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Entregador>> listarEntregadores() {
        List<Entregador> entregadores = entregadorService.listarEntregadores();
        return ResponseEntity.ok(entregadores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (entregadorService.deletarEntregador(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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
