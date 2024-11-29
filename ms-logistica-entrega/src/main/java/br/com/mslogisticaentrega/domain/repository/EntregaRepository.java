package br.com.mslogisticaentrega.domain.repository;

import br.com.mslogisticaentrega.domain.Entrega;
import java.util.List;
import java.util.Optional;

public interface EntregaRepository {
    Optional<Entrega> findById(Long id);
    Entrega save(Entrega entrega);
    void deleteById(Long id);
    List<Entrega> findAll();
}
