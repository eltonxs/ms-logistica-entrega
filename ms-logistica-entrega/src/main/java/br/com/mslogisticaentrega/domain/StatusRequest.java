package br.com.mslogisticaentrega.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StatusRequest {

    @NotNull(message = "O novo status não pode ser nulo.")
    @Pattern(
            regexp = "PENDENTE|EM_TRANSITO|ENTREGUE|CANCELADA",
            message = "O status deve ser um dos seguintes: PENDENTE, EM_TRANSITO, ENTREGUE, CANCELADA"
    )
    private String novoStatus;

    public String getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(String novoStatus) {
        this.novoStatus = novoStatus;
    }
}
