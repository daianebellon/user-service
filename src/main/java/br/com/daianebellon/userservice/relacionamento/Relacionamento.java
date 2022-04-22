package br.com.daianebellon.userservice.relacionamento;

import br.com.daianebellon.userservice.telefone.Telefone;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "relacionamento_telefone")
public class Relacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parentesco")
    private String parentesco;

    @JoinColumn(name = "telefone_id")
    @OneToOne
    private Telefone telefone;

}
