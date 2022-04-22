package br.com.daianebellon.userservice.pessoa.service;

import br.com.daianebellon.userservice.pessoa.converter.ConvertePessoa;
import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    PessoaRepository pessoaRepository;
    ConvertePessoa convertePessoa;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, ConvertePessoa convertePessoa) {
        this.pessoaRepository = pessoaRepository;
        this.convertePessoa = convertePessoa;
    }

    @Override
    public Pessoa save(PessoaDTO pessoaDTO) {
        ValidaPessoa.validar(pessoaDTO);
        Pessoa pessoa = convertePessoa.converter(pessoaDTO);

        return pessoaRepository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id inválido");
        }

        return pessoaRepository.findById(id);
    }
}
