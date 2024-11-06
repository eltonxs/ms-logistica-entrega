package br.com.mslogisticaentrega.repository;

import br.com.mslogisticaentrega.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByStatus(String status);
}
