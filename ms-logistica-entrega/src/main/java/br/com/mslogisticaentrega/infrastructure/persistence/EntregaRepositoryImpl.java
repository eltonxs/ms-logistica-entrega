package br.com.mslogisticaentrega.infrastructure.persistence;

import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.domain.repository.EntregaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EntregaRepositoryImpl implements EntregaRepository {

    private final JpaEntregaRepository jpaRepository;

    public EntregaRepositoryImpl(JpaEntregaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Entrega> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Entrega save(Entrega entrega) {
        return jpaRepository.save(entrega);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Entrega> findAll() {
        return jpaRepository.findAll();
    }
}
