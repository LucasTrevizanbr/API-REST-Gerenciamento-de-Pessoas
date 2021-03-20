package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MensagemResposta;
import one.digitalinnovation.personapi.model.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import one.digitalinnovation.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemResposta criarPessoa(@RequestBody Pessoa pessoa){
       return pessoaService.criarPessoa(pessoa);
    }

}
