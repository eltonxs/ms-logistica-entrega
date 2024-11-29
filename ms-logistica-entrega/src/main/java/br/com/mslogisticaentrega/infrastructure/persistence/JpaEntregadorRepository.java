package br.com.mslogisticaentrega.infrastructure.persistence;

import br.com.mslogisticaentrega.domain.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEntregadorRepository extends JpaRepository<Entregador, Long> {
    boolean existsByCpf(String cpf);           // Verifica duplicidade de CPF
    boolean existsByTelefone(String telefone); // Verifica duplicidade de telefone
}
