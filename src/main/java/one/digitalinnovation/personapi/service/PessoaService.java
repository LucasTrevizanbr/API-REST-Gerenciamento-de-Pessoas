package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MensagemResposta;
import one.digitalinnovation.personapi.dto.request.PessoaDto;
import one.digitalinnovation.personapi.exception.PessoaNotFoundException;
import one.digitalinnovation.personapi.mapper.PessoaMapper;
import one.digitalinnovation.personapi.model.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;


    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MensagemResposta criarPessoa(PessoaDto pessoaDto){
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDto);
        Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalvar);
        return criarMensagemResposta(pessoaSalva.getId(),"Criada pessoa com id: ");
    }

    public List<PessoaDto> listarTodos() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }



    public PessoaDto acharPorID(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificarSeExiste(id);
        return pessoaMapper.toDTO(pessoa);
    }

    public void deletarPorId(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificarSeExiste(id);
        pessoaRepository.deleteById(id);
    }


    public MensagemResposta atualizarPorId(Long id, PessoaDto pessoaDto) throws PessoaNotFoundException {
        verificarSeExiste(id);
        Pessoa pessoaParaAtualizar = pessoaMapper.toModel(pessoaDto);
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoaParaAtualizar);
        return criarMensagemResposta(pessoaAtualizada.getId(),"Atualizada pessoa com id: ");

    }

    private Pessoa verificarSeExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    private MensagemResposta criarMensagemResposta(Long id, String mensagem) {
        return MensagemResposta
                .builder()
                .mensagem(mensagem + id )
                .build();
    }
}
