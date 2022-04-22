package br.com.daianebellon.userservice.endereo;

import lombok.Getter;

@Getter
public class EnderecoDTO {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

}
