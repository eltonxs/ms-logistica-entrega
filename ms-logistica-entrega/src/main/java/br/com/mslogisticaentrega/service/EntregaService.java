package br.com.mslogisticaentrega.service;

import br.com.mslogisticaentrega.infra.PedidoClient;
import br.com.mslogisticaentrega.model.Entrega;
import br.com.mslogisticaentrega.model.StatusEntrega;
import br.com.mslogisticaentrega.repository.EntregaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

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
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataCriacao(LocalDateTime.now());
        return entregaRepository.save(entrega);
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
}
