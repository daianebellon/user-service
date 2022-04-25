package br.com.daianebellon.userservice.pessoa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

}
