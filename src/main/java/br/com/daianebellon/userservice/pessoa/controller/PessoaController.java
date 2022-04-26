package br.com.daianebellon.userservice.pessoa.controller;

import br.com.daianebellon.userservice.pessoa.domain.Pessoa;
import br.com.daianebellon.userservice.pessoa.dto.PessoaDTO;
import br.com.daianebellon.userservice.pessoa.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoa(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Long> cadastrar(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.save(pessoaDTO));
    }
}
