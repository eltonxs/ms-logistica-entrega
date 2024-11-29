package br.com.mslogisticaentrega.integration.service;

import br.com.mslogisticaentrega.domain.Entregador;
import br.com.mslogisticaentrega.domain.repository.EntregadorRepository;
import br.com.mslogisticaentrega.exception.DuplicidadeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public Entregador criarEntregador(Entregador entregador) {
        if (entregadorRepository.existsByCpf(entregador.getCpf())) {
            throw new DuplicidadeException("CPF já cadastrado.");
        }

        if (entregadorRepository.existsByTelefone(entregador.getTelefone())) {
            throw new DuplicidadeException("Número de telefone já cadastrado.");
        }

        return entregadorRepository.save(entregador);
    }

    public Optional<Entregador> buscarPorId(Long id) {
        return entregadorRepository.findById(id);
    }

    public Optional<Entregador> atualizarEntregador(Long id, Entregador entregador) {
        return entregadorRepository.findById(id)
                .map(entregadorExistente -> {
                    entregadorExistente.setNome(entregador.getNome());
                    entregadorExistente.setVeiculo(entregador.getVeiculo());
                    entregadorExistente.setCpf(entregador.getCpf());
                    entregadorExistente.setTelefone(entregador.getTelefone());
                    return entregadorRepository.save(entregadorExistente);
                });
    }

    public List<Entregador> listarEntregadores() {
        return entregadorRepository.findAll();
    }

    public boolean deletarEntregador(Long id) {
        if (entregadorRepository.existsById(id)) {
            entregadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
