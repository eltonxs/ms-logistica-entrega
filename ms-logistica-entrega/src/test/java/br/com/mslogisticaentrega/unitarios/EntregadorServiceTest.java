package br.com.mslogisticaentrega.unitarios;


import br.com.mslogisticaentrega.integration.service.EntregadorService;
import br.com.mslogisticaentrega.domain.Entregador;
import br.com.mslogisticaentrega.domain.repository.EntregadorRepository;
import br.com.mslogisticaentrega.exception.DuplicidadeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EntregadorServiceTest {

    @Mock
    private EntregadorRepository entregadorRepository;

    @InjectMocks
    private EntregadorService entregadorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarEntregadorComSucesso() {
        Entregador entregador = new Entregador();
        entregador.setCpf("12345678901");
        entregador.setTelefone("(11)980808070");
        entregador.setNome("Entregador Teste");
        entregador.setVeiculo("Moto");
        when(entregadorRepository.existsByCpf(entregador.getCpf())).thenReturn(false);
        when(entregadorRepository.existsByTelefone(entregador.getTelefone())).thenReturn(false);
        when(entregadorRepository.save(entregador)).thenReturn(entregador);
        Entregador result = entregadorService.criarEntregador(entregador);
        assertThat(result).isNotNull();
        assertThat(result.getCpf()).isEqualTo("12345678901");
        verify(entregadorRepository).save(entregador);
    }

    @Test
    void naoDeveCriarEntregadorComCpfDuplicado() {
        Entregador entregador = new Entregador();
        entregador.setCpf("12345678901");
        when(entregadorRepository.existsByCpf(entregador.getCpf())).thenReturn(true);
        assertThrows(DuplicidadeException.class, () -> entregadorService.criarEntregador(entregador));
        verify(entregadorRepository, never()).save(any());
    }

    @Test
    void criarEntregador_deveLancarExcecaoQuandoCpfDuplicado() {
        Entregador entregador = new Entregador();
        entregador.setCpf("12345678900");
        when(entregadorRepository.existsByCpf("12345678900")).thenReturn(true);
        assertThrows(DuplicidadeException.class, () -> entregadorService.criarEntregador(entregador));
    }

}
