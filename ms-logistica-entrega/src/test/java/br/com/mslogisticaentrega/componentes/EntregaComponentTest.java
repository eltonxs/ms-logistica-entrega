package br.com.mslogisticaentrega.componentes;


import br.com.mslogisticaentrega.controller.EntregaController;
import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.domain.StatusEntrega;
import br.com.mslogisticaentrega.integration.service.EntregaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EntregaController.class)
public class EntregaComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntregaService entregaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Entrega entrega;

    @BeforeEach
    void setUp() {
        entrega = new Entrega();
        entrega.setId(1L);
        entrega.setPedidoId(123L);
        entrega.setEntregadorId(456L);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataCriacao(LocalDateTime.now());
        entrega.setDataAtualizacao(LocalDateTime.now());
        entrega.setLogradouro("Rua Teste");
        entrega.setNumero("123");
        entrega.setBairro("Bairro Teste");
        entrega.setCidade("Cidade Teste");
        entrega.setEstado("SP");
        entrega.setCepDestino("12345678");
        entrega.setLatitude(-23.5);
        entrega.setLongitude(-46.6);
    }

    @Test
    void criarEntrega_deveRetornarEntregaCriada() throws Exception {
        when(entregaService.criarEntrega(any(Entrega.class))).thenReturn(entrega);
        mockMvc.perform(post("/entregas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entrega))) // Envia objeto válido
                .andExpect(status().isCreated()) // Valida status 201
                .andExpect(jsonPath("$.id").value(1)) // Valida ID retornado
                .andExpect(jsonPath("$.status").value("PENDENTE")); // Valida status retornado
        verify(entregaService, times(1)).criarEntrega(any(Entrega.class));
    }


    @Test
    void listarEntregas_deveRetornarListaDeEntregas() throws Exception {
        List<Entrega> entregas = Arrays.asList(entrega, entrega);
        when(entregaService.listarEntregas()).thenReturn(entregas);
        mockMvc.perform(get("/entregas")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
        verify(entregaService, times(1)).listarEntregas();
    }

    @Test
    void atualizarLocalizacao_deveAtualizarLocalizacaoEDevolverNoContent() throws Exception {
        // Act & Assert
        mockMvc.perform(put("/entregas/1/localizacao")
                        .param("latitude", "-23.5")
                        .param("longitude", "-46.6"))
                .andExpect(status().isNoContent());
        verify(entregaService, times(1)).atualizarLocalizacaoEntrega(1L, -23.5, -46.6);
    }

}
