package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.converter.PessoaConverter;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;
import br.com.daianebellon.userservice.pessoa.exceptions.RegistroNaoEncontradoException;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import br.com.daianebellon.userservice.pessoa.validacoes.IdValidation;
import br.com.daianebellon.userservice.pessoa.validacoes.PessoaValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaConverter pessoaConverter;
    private final PessoaValidation pessoaValidation;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, PessoaConverter convertePessoa, PessoaValidation pessoaValidation) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaConverter = convertePessoa;
        this.pessoaValidation = pessoaValidation;
    }

    @Override
    public Long cadastrar(PessoaDTO pessoaDTO) {
        pessoaValidation.validar(pessoaDTO, null);
        Pessoa pessoa = pessoaConverter.converter(pessoaDTO);
        return pessoaRepository.save(pessoa).getId();
    }

    @Override
    public Long editar(Long id, PessoaDTO pessoaDTO) {
        pessoaRepository.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException(
                        String.format(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION.getMensagem(), id)));
        pessoaValidation.validar(pessoaDTO, id);
        Pessoa pessoa = pessoaConverter.converter(pessoaDTO);
        return pessoaRepository.save(pessoa).getId();
    }

    @Override
    public ResponseEntity excluir(Long id) {
        pessoaRepository.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException(
                        String.format(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION.getMensagem(), id)));
        try {
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public Pessoa findById(Long id) {
        IdValidation.validar(id);
        return pessoaRepository.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException(String.format(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION.getMensagem(), id)));
    }
}
