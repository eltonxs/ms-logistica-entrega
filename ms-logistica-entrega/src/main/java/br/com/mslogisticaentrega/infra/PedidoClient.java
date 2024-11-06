package br.com.mslogisticaentrega.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedidoClient", url = "http://localhost:8081")
public interface PedidoClient {

    @GetMapping("/pedidos/{id}")
    String buscarPedido(@PathVariable("id") Long id);
}
