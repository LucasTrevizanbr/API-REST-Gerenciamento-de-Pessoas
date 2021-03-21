package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.MensagemResposta;
import one.digitalinnovation.personapi.dto.request.PessoaDto;
import one.digitalinnovation.personapi.exception.PessoaNotFoundException;
import one.digitalinnovation.personapi.model.Pessoa;
import one.digitalinnovation.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MensagemResposta criarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
       return pessoaService.criarPessoa(pessoaDto);
    }

    @GetMapping
    public List<PessoaDto> listarTodos(){
       return pessoaService.listarTodos();
    }

    @GetMapping("/{id}")
    public PessoaDto acharPorId(@PathVariable Long id) throws PessoaNotFoundException {
        return pessoaService.acharPorID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) throws PessoaNotFoundException {
       pessoaService.deletarPorId(id);
    }

}
