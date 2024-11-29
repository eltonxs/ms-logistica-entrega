package br.com.mslogisticaentrega.infrastructure.persistence;

import br.com.mslogisticaentrega.domain.Entregador;
import br.com.mslogisticaentrega.domain.repository.EntregadorRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class EntregadorRepositoryImpl implements EntregadorRepository {

    private final JpaEntregadorRepository jpaRepository;

    public EntregadorRepositoryImpl(JpaEntregadorRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Entregador> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Entregador save(Entregador entregador) {
        return jpaRepository.save(entregador);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByTelefone(String telefone) {
        return jpaRepository.existsByTelefone(telefone);
    }

    @Override
    public List<Entregador> findAll() {
        return jpaRepository.findAll();
    }
}
