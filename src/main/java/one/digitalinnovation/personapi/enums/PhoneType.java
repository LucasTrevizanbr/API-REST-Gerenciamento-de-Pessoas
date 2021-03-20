package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    Residencial("Residencial"),
    Celular("Celular"),
    Comercial("Comercial");

    private final String descricao;


}
