package br.com.daianebellon.userservice.pessoa.converter;

import br.com.daianebellon.userservice.pessoa.domain.Telefone;
import br.com.daianebellon.userservice.pessoa.domain.Relacionamento;
import br.com.daianebellon.userservice.pessoa.dto.TelefoneDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelefoneConverter {

    public List<Telefone> converter(List<TelefoneDTO> telefonesDTO) {
        ArrayList<Telefone> telefones = new ArrayList<>();

        for (TelefoneDTO telefoneDTO : telefonesDTO) {
            Telefone telefone = new Telefone();
            telefone.setNumero(telefoneDTO.getNumero());

            if (telefoneDTO.getRelacionamento() != null) {
                Relacionamento relacionamento = new Relacionamento();
                relacionamento.setTelefone(telefone);
                relacionamento.setParentesco(telefoneDTO.getRelacionamento().getParentesco());
                telefone.setRelacionamento(relacionamento);
            } else {
                telefone.setRelacionamento(new Relacionamento());
            }

            telefones.add(telefone);
        }

        return telefones;
    }
}
