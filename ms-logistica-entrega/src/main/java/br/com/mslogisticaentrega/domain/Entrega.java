package br.com.mslogisticaentrega.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O ID do pedido não pode ser nulo.")
    private Long pedidoId;

    @NotNull(message = "O ID do entregador não pode ser nulo.")
    private Long entregadorId;

    @NotNull(message = "O status da entrega não pode ser nulo.")
    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @NotNull(message = "A data de criação não pode ser nula.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    @NotNull(message = "A data de atualização não pode ser nula.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataAtualizacao;

    @NotNull(message = "O logradouro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O logradouro deve ter entre 3 e 255 caracteres.")
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo.")
    @Size(min = 1, max = 20, message = "O número deve ter entre 1 e 20 caracteres.")
    private String numero;

    @NotNull(message = "O bairro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O bairro deve ter entre 3 e 255 caracteres.")
    private String bairro;

    @NotNull(message = "A cidade não pode ser nula.")
    @Size(min = 3, max = 255, message = "A cidade deve ter entre 3 e 255 caracteres.")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo.")
    @Size(min = 2, max = 2, message = "O estado deve conter exatamente 2 caracteres.")
    private String estado;

    @NotNull(message = "O CEP não pode ser nulo.")
    @Size(min = 8, max = 8, message = "O CEP deve conter exatamente 8 caracteres.")
    private String cepDestino;

    @NotNull(message = "A latitude não pode ser nula.")
    private Double latitude;

    @NotNull(message = "A longitude não pode ser nula.")
    private Double longitude;

    // Getters e Setters
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCepDestino() { return cepDestino; }
    public void setCepDestino(String cepDestino) { this.cepDestino = cepDestino; }
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
