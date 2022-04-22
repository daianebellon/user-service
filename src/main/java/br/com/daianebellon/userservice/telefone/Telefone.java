package br.com.daianebellon.userservice.telefone;

import br.com.daianebellon.userservice.pessoa.Pessoa;
import br.com.daianebellon.userservice.relacionamento.Relacionamento;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(mappedBy = "telefone")
    private Relacionamento relacionamento;

}
