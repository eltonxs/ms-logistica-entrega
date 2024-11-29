package br.com.mslogisticaentrega.unitarios;


import br.com.mslogisticaentrega.controller.EntregaController;
import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.integration.service.EntregaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class EntregaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Para converter objetos em JSON

    @InjectMocks
    private EntregaController entregaController;

    @Mock
    private EntregaService entregaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarEntrega_deveRetornarNovaEntrega() {
        // Arrange
        Entrega entrega = new Entrega();
        entrega.setId(1L);
        when(entregaService.criarEntrega(any(Entrega.class))).thenReturn(entrega);

        // Act
        ResponseEntity<Entrega> response = entregaController.criarEntrega(new Entrega());

        // Assert
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        verify(entregaService, times(1)).criarEntrega(any());
    }

    @Test
    void listarEntregas_deveRetornarListaDeEntregas() {
        // Arrange
        List<Entrega> entregas = new ArrayList<>();
        entregas.add(new Entrega());
        when(entregaService.listarEntregas()).thenReturn(entregas);

        // Act
        ResponseEntity<List<Entrega>> response = entregaController.listarEntregas();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        verify(entregaService, times(1)).listarEntregas();
    }

    @Test
    void atualizarStatus_deveAtualizarEDevolverNoContent() {
        // Act
        ResponseEntity<Void> response = entregaController.atualizarLocalizacao(1L, -23.5, -46.6);

        // Assert
        assertEquals(204, response.getStatusCodeValue()); // Atualizado para 204
        verify(entregaService, times(1)).atualizarLocalizacaoEntrega(1L, -23.5, -46.6);
    }



    }
