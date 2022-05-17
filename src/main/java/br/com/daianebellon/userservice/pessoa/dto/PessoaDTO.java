package br.com.daianebellon.userservice.pessoa.dto;

import br.com.daianebellon.userservice.pessoa.exceptions.CampoInvalidoException;
import br.com.daianebellon.userservice.pessoa.exceptions.ErrorMessages;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PessoaDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String documentoPessoal;
    private LocalDate dataNascimento;
    private EnderecoDTO endereco;

    @Getter(AccessLevel.NONE)
    private List<TelefoneDTO> telefones;

    public List<TelefoneDTO> getTelefones() {
        if (telefones.size() > 2) {
            throw new CampoInvalidoException(ErrorMessages.PESSOA_NAO_DEVE_POSSUIR_MAIS_QUE_DOIS_REGISTROS_EXCEPTION, "telefones");
        }
        return telefones;
    }
}