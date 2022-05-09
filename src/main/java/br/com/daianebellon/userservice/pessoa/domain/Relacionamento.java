package br.com.daianebellon.userservice.pessoa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "relacionamento_telefone")
public class Relacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parentesco")
    private String parentesco;

    @JsonIgnore
    @JoinColumn(name = "telefone_id")
    @OneToOne
    private Telefone telefone;

    public Relacionamento(Long id, String parentesco, Telefone telefone) {
        this.id = id;
        this.parentesco = parentesco;
        this.telefone = telefone;
    }

    public Relacionamento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
