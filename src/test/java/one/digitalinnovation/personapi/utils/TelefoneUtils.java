package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.TelefoneDto;
import one.digitalinnovation.personapi.enums.PhoneType;
import one.digitalinnovation.personapi.model.Telefone;

public class TelefoneUtils {

    private static final String NUMERO = "1169734-0882";
    private static final PhoneType TIPO = PhoneType.Celular;
    private static final Long TELEFONE_ID = 1L;

    public static TelefoneDto criarFakeDto() {
        return TelefoneDto.builder()
                .numero(NUMERO)
                .tipo(TIPO)
                .id(TELEFONE_ID)
                .build();
    }

    public static Telefone criarEntidadeFake() {
        return Telefone.builder()
                .numero(NUMERO)
                .tipo(TIPO)
                .id(TELEFONE_ID)
                .build();
    }
}
