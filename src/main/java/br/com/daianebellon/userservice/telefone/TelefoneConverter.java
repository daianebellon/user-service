package br.com.daianebellon.userservice.telefone;

import br.com.daianebellon.userservice.relacionamento.Relacionamento;
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
            }

            telefones.add(telefone);
        }

        return telefones;
    }

}
