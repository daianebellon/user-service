package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.converter.PessoaConverter;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;
import br.com.daianebellon.userservice.pessoa.exceptions.RegistroNaoEncontradoException;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import br.com.daianebellon.userservice.pessoa.validacoes.PessoaValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @Mock
    private PessoaValidation pessoaValidation;

    @Mock
    private PessoaConverter pessoaConverter;

    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    void deveCadastrarPessoa() {

    }

    @Test
    void cadastrar() {
    }

    @Test
    void editar() {
        PessoaDTO pessoaDTOMock = new PessoaDTO();
        pessoaDTOMock.setId(2L);
        pessoaDTOMock.setNome("Daiane");

        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(2L);
        pessoaMock.setNome("Daiane");

        when(pessoaRepository.existsById(2L)).thenReturn(true);
        doNothing().when(pessoaValidation).validaEditarPessoaDTO(pessoaDTOMock);
        when(pessoaConverter.converter(pessoaDTOMock)).thenReturn(pessoaMock);
        when(pessoaRepository.save(pessoaMock)).thenReturn(pessoaMock);

        Long idPessoa = pessoaService.editar(2L, pessoaDTOMock);

        assertEquals(pessoaDTOMock.getId(), idPessoa);
    }

    @Test
    void deveExcluirPeloId() {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(1L);

        when(pessoaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(pessoaRepository).deleteById(1L);

        assertDoesNotThrow(() -> {
            pessoaService.excluir(1L);
        });

        verify(pessoaRepository).deleteById(pessoaMock.getId());
    }

    @Test
    void deveBuscarPeloId() {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(10L);
        pessoaMock.setNome("Daiane");

        when(pessoaRepository.findById(10L)).thenReturn(Optional.of(pessoaMock));

        Pessoa pessoa = pessoaService.findById(10L);

        assertEquals(pessoaMock.getId(), pessoa.getId());
        assertEquals(pessoaMock.getNome(), pessoa.getNome());
    }

    @Test
    void deveLancarExcecaoQuandoIdNaoExistir() {
        when(pessoaRepository.findById(10L)).thenReturn(Optional.empty());

        RegistroNaoEncontradoException registroNaoEncontradoException = assertThrows(RegistroNaoEncontradoException.class, () -> {
            pessoaService.findById(10L);
        });

        assertEquals(String.format(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION.getMensagem(), 10L), registroNaoEncontradoException.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoIdEhNull() {
        CampoInvalidoException campoInvalidoException = assertThrows(CampoInvalidoException.class, () -> {
            pessoaService.findById(null);
        });

        assertEquals(String.format(ErrorMessages.CAMPO_INVALIDO_EXCEPTION.getMensagem(), "id"), campoInvalidoException.getMessage());
    }
}