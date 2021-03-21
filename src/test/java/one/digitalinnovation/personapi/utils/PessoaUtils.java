package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PessoaDto;
import one.digitalinnovation.personapi.model.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String PRIMEIRO_NOME = "Lucas";
    private static final String SOBRENOME = "Trevizan";
    private static final String CPF = "480.861.988-12";
    private static final Long PESSOA_ID = 1L;
    public static final LocalDate DATANASC = LocalDate.of(1999,1,8);

    public static PessoaDto criarFakeDto(){
        return PessoaDto.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .id(PESSOA_ID)
                .dataNasc("08-01-1999")
                .telefones(Collections.singletonList(TelefoneUtils.criarFakeDto()))
                .build();
    }

    public static Pessoa criarEntidadeFake(){
        return Pessoa.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .id(PESSOA_ID)
                .dataNasc(DATANASC)
                .telefones(Collections.singletonList(TelefoneUtils.criarEntidadeFake()))
                .build();
    }


}
