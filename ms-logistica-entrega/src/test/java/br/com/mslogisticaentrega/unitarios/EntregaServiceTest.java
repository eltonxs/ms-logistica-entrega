package br.com.mslogisticaentrega.unitarios;


import br.com.mslogisticaentrega.domain.Entrega;
import br.com.mslogisticaentrega.domain.StatusEntrega;
import br.com.mslogisticaentrega.domain.repository.EntregaRepository;
import br.com.mslogisticaentrega.infra.PedidoClient;
import br.com.mslogisticaentrega.integration.service.EntregaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EntregaServiceTest {

    @InjectMocks
    private EntregaService entregaService;
    @Mock
    private EntregaRepository entregaRepository;
    @Mock
    private PedidoClient pedidoClient;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarEntrega_deveSalvarEntregaComStatusPendente() {
        Entrega entrega = new Entrega();
        when(entregaRepository.save(any(Entrega.class))).thenAnswer(invocation -> {
            Entrega e = invocation.getArgument(0);
            e.setId(1L);
            return e;
        });
        Entrega resultado = entregaService.criarEntrega(entrega);
        assertNotNull(resultado);
        assertEquals(StatusEntrega.PENDENTE, resultado.getStatus());
        verify(entregaRepository, times(1)).save(entrega);
    }

    @Test
    void atualizarStatus_deveAlterarStatusComSucesso() {
        Entrega entrega = new Entrega();
        entrega.setId(1L);
        entrega.setStatus(StatusEntrega.PENDENTE);
        when(entregaRepository.findById(1L)).thenReturn(Optional.of(entrega));
        when(entregaRepository.save(any(Entrega.class))).thenReturn(entrega);
        Entrega resultado = entregaService.atualizarStatus(1L, StatusEntrega.ENTREGUE);
        assertNotNull(resultado);
        assertEquals(StatusEntrega.ENTREGUE, resultado.getStatus());
        verify(entregaRepository, times(1)).findById(1L);
        verify(entregaRepository, times(1)).save(entrega);
    }

    @Test
    void atualizarStatus_deveLancarExcecaoSeEntregaNaoEncontrada() {
        when(entregaRepository.findById(1L)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            entregaService.atualizarStatus(1L, StatusEntrega.ENTREGUE);
        });
        assertEquals("Entrega não encontrada", exception.getMessage());
        verify(entregaRepository, times(1)).findById(1L);
        verify(entregaRepository, never()).save(any());
    }

    @Test
    void atualizarStatus_deveLancarExcecaoQuandoEntregaNaoEncontrada() {
        when(entregaRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> entregaService.atualizarStatus(99L, StatusEntrega.EM_TRANSITO));
    }

    @Test
    void listarEntregas_deveRetornarListaDeEntregas() {
        List<Entrega> entregas = List.of(new Entrega(), new Entrega());
        when(entregaRepository.findAll()).thenReturn(entregas);
        List<Entrega> resultado = entregaService.listarEntregas();
        assertEquals(2, resultado.size());
        verify(entregaRepository, times(1)).findAll();
    }
    }