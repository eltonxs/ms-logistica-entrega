package br.com.mslogisticaentrega.componentes;

import br.com.mslogisticaentrega.domain.Entregador;
import br.com.mslogisticaentrega.integration.service.EntregaService;
import br.com.mslogisticaentrega.integration.service.EntregadorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EntregadorComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EntregadorService entregadorService;

    @MockBean
    private EntregaService entregaService; // Adicionado para resolver o erro

    private Entregador entregador;

    @BeforeEach
    void setUp() {
        entregador = new Entregador();
        entregador.setId(1L);
        entregador.setNome("João Silva");
        entregador.setCpf("12345678901");
        entregador.setTelefone("11999999999");
    }

    @Test
    void criarEntregador_deveRetornarEntregadorCriado() throws Exception {
        when(entregadorService.criarEntregador(any(Entregador.class))).thenReturn(entregador);
        mockMvc.perform(post("/entregadores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entregador)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.cpf").value("12345678901"))
                .andExpect(jsonPath("$.telefone").value("11999999999"));
    }

    @Test
    void listarEntregadores_deveRetornarListaDeEntregadores() throws Exception {
         List<Entregador> entregadores = Arrays.asList(entregador);
        when(entregadorService.listarEntregadores()).thenReturn(entregadores);
        mockMvc.perform(get("/entregadores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }

    @Test
    void buscarEntregadorPorId_deveRetornarEntregador() throws Exception {
           when(entregadorService.buscarPorId(1L)).thenReturn(Optional.of(entregador));
        mockMvc.perform(get("/entregadores/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }


    @Test
    void atualizarEntregador_deveRetornarNoContent() throws Exception {
        mockMvc.perform(put("/entregadores/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entregador)))
                .andExpect(status().isNoContent());
    }

    @Test
    void deletarEntregador_deveRetornarNoContent() throws Exception {
        mockMvc.perform(delete("/entregadores/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
