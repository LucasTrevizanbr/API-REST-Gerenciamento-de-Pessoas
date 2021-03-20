package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MensagemResposta;
import one.digitalinnovation.personapi.model.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MensagemResposta criarPessoa(Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return MensagemResposta
                .builder()
                .mensagem("Pessoa criada com o id: "+ pessoaSalva.getId())
                .build();
    }
}
