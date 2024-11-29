package br.com.mslogisticaentrega.domain.repository;

import br.com.mslogisticaentrega.domain.Entregador;
import java.util.List;
import java.util.Optional;

public interface EntregadorRepository {
    Optional<Entregador> findById(Long id);
    Entregador save(Entregador entregador);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByCpf(String cpf);      // Para verificar duplicidade de CPF
    boolean existsByTelefone(String telefone);  // Para verificar duplicidade de telefone
    List<Entregador> findAll();
}
