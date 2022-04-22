package br.com.daianebellon.userservice.pessoa;

import br.com.daianebellon.userservice.endereo.Endereco;
import br.com.daianebellon.userservice.telefone.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;

    @Size(min = 11, max = 14)
    @Column(name = "documento_pessoal")
    private String documentoPessoal;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;

}
