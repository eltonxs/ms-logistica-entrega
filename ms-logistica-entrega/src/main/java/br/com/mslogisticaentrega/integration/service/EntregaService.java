package br.com.mslogisticaentrega.integration.service;

import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.domain.StatusEntrega;
import br.com.mslogisticaentrega.domain.repository.EntregaRepository;
import br.com.mslogisticaentrega.infra.PedidoClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;
    private final PedidoClient pedidoClient;

    public EntregaService(EntregaRepository entregaRepository, PedidoClient pedidoClient) {
        this.entregaRepository = entregaRepository;
        this.pedidoClient = pedidoClient;
    }

    public String buscarPedido(Long pedidoId) {
        return pedidoClient.buscarPedido(pedidoId);
    }

    public Entrega criarEntrega(Entrega entrega) {
        if (entrega.getStatus() == null) {
            entrega.setStatus(StatusEntrega.PENDENTE);
        }
        entrega.setDataCriacao(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }

    public Optional<Entrega> buscarPorId(Long id) {
        return entregaRepository.findById(id);
    }

    public Entrega atualizarStatus(Long id, StatusEntrega novoStatus) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setStatus(novoStatus);
        entrega.setDataAtualizacao(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }

    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    public void atualizarLocalizacaoEntrega(Long id, Double latitude, Double longitude) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setLatitude(latitude);
        entrega.setLongitude(longitude);
        entregaRepository.save(entrega);
    }

    public Entrega obterEntregaPorId(Long id) {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
    }
}
