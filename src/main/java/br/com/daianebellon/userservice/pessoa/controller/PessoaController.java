package br.com.daianebellon.userservice.pessoa.controller;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);

        if (pessoa.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(pessoa.get());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.save(pessoaDTO));
    }
}
