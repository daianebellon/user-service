package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.converter.PessoaConverter;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;
import br.com.daianebellon.userservice.pessoa.exceptions.RegistroNaoEncontradoException;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import br.com.daianebellon.userservice.pessoa.validacoes.PessoaValidation;
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
        pessoaValidation.validaCadastroPessoaDTO(pessoaDTO);
        Pessoa pessoa = pessoaConverter.converter(pessoaDTO);
        return pessoaRepository.save(pessoa).getId();
    }

    @Override
    public Long editar(Long id, PessoaDTO pessoaDTO) {
        validaSeExistePessoa(id);
        pessoaValidation.validaEditarPessoaDTO(pessoaDTO);
        Pessoa pessoa = pessoaConverter.converter(pessoaDTO);
        return pessoaRepository.save(pessoa).getId();
    }

    @Override
    public void excluir(Long id) {
        validaSeExistePessoa(id);
        pessoaRepository.deleteById(id);
    }

    @Override
    public Pessoa findById(Long id) {
        validaLongNull(id, "id");
        return pessoaRepository.findById(id).orElseThrow(
                () -> new RegistroNaoEncontradoException(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION, id));
    }

    private void validaSeExistePessoa(Long id) {
        validaLongNull(id, "id");
        if (!pessoaRepository.existsById(id)) {
            throw new RegistroNaoEncontradoException(ErrorMessages.PESSOA_NAO_ENCONTRADA_EXCEPTION, id);
        }
    }

    private void validaLongNull(Long chave, String valor) {
        if (chave == null) {
            throw new CampoInvalidoException(ErrorMessages.CAMPO_INVALIDO_EXCEPTION, valor);
        }
    }
}
