package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MensagemResposta;
import one.digitalinnovation.personapi.dto.request.PessoaDto;
import one.digitalinnovation.personapi.model.Pessoa;
import one.digitalinnovation.personapi.repository.PessoaRepository;
import one.digitalinnovation.personapi.utils.PessoaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PessoaUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTeste {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testeDadoPessoaDtoEntaoRetorneMensagemSalva() {
       PessoaDto pessoaDto = criarFakeDto();
       Pessoa pessoaEsperadaParaSalvar  = criarEntidadeFake();

        when(pessoaRepository.save(pessoaEsperadaParaSalvar)).thenReturn(pessoaEsperadaParaSalvar);

        MensagemResposta msgEsperada = criarMensagemEsperadaDeResposta(pessoaEsperadaParaSalvar.getId());

        MensagemResposta msgSucesso = pessoaService.criarPessoa(pessoaDto);

        Assertions.assertEquals(msgEsperada,msgSucesso);
    }

    private MensagemResposta criarMensagemEsperadaDeResposta(Long id) {
        return MensagemResposta
                .builder()
                .mensagem("Criada pessoa com id: " + id)
                .build();
    }


}
