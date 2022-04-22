package br.com.daianebellon.userservice.pessoa;

import java.util.Optional;

public interface PessoaService {

    Pessoa save(PessoaDTO pessoaDTO);

    Optional<Pessoa> findById(Long id);
}
