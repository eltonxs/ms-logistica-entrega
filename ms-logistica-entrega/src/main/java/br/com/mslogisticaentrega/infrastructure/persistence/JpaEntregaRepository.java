package br.com.mslogisticaentrega.infrastructure.persistence;

import br.com.mslogisticaentrega.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEntregaRepository extends JpaRepository<Entrega, Long> {
}
