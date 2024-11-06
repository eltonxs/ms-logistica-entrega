package br.com.mslogisticaentrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    private String nome;

    @NotBlank(message = "O veículo não pode ser nulo ou vazio")
    private String veiculo;

    @NotBlank(message = "O CPF não pode ser nulo ou vazio")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @NotBlank(message = "O telefone não pode ser nulo ou vazio")
    @Pattern(
            regexp = "\\(\\d{2}\\)\\d{8,9}",
            message = "O telefone deve estar no formato (11)980713480"
    )
    private String telefone;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}