package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.converter.PessoaConverter;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.exceptions.RegistroNaoEncontradoException;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import br.com.daianebellon.userservice.pessoa.validacoes.IdValidation;
import br.com.daianebellon.userservice.pessoa.validacoes.PessoaValidation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    PessoaRepository pessoaRepository;
    PessoaConverter pessoaConverter;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, PessoaConverter convertePessoa) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaConverter = convertePessoa;
    }

    @Override
    public Long save(PessoaDTO pessoaDTO) {
        PessoaValidation.validar(pessoaDTO);
        Pessoa pessoa = pessoaConverter.converter(pessoaDTO);
        return pessoaRepository.save(pessoa).getId();
    }

    @Override
    public Pessoa findById(Long id) {
        IdValidation.validar(id);

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isEmpty()) {
            throw new RegistroNaoEncontradoException("Não foi encontrado uma pessoa com o id: " + id);
        }

        return pessoa.get();
    }
}
