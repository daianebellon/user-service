package br.com.daianebellon.userservice.pessoa.dto;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.domain.Relacionamento;
import lombok.Getter;

@Getter
public class TelefoneDTO {

    private String numero;
    private Pessoa pessoa;
    private Relacionamento relacionamento;

}
