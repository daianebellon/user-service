package br.com.daianebellon.userservice.telefone;

import br.com.daianebellon.userservice.pessoa.Pessoa;
import br.com.daianebellon.userservice.relacionamento.Relacionamento;
import lombok.Getter;

@Getter
public class TelefoneDTO {

    private String numero;
    private Pessoa pessoa;
    private Relacionamento relacionamento;

}
