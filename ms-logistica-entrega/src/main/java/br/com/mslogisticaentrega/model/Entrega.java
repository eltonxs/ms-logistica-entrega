package br.com.mslogisticaentrega.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedidoId;
    private Long entregadorId;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPedidoId() { return pedidoId; }
    public void setPedidoId(Long pedidoId) { this.pedidoId = pedidoId; }

    public Long getEntregadorId() { return entregadorId; }
    public void setEntregadorId(Long entregadorId) { this.entregadorId = entregadorId; }

    public StatusEntrega getStatus() { return status; }
    public void setStatus(StatusEntrega status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
}
