package br.com.mslogisticaentrega.controller;

import br.com.mslogisticaentrega.model.Entregador;
import br.com.mslogisticaentrega.repository.EntregadorRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    private final EntregadorRepository entregadorRepository;

    public EntregadorController(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    @PostMapping
    public ResponseEntity<Entregador> criarEntregador(@Valid @RequestBody Entregador entregador) {
        Entregador novoEntregador = entregadorRepository.save(entregador);
        return ResponseEntity.status(201).body(novoEntregador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEntregador(
            @PathVariable Long id,
            @Valid @RequestBody Entregador entregador) {

        return entregadorRepository.findById(id)
                .map(entregadorExistente -> {
                    entregadorExistente.setNome(entregador.getNome());
                    entregadorExistente.setVeiculo(entregador.getVeiculo());
                    entregadorExistente.setCpf(entregador.getCpf());
                    entregadorExistente.setTelefone(entregador.getTelefone());
                    entregadorRepository.save(entregadorExistente);
                    return ResponseEntity.ok(entregadorExistente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Entregador>> listarEntregadores() {
        List<Entregador> entregadores = entregadorRepository.findAll();
        return ResponseEntity.ok(entregadores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (entregadorRepository.existsById(id)) {
            entregadorRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
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

