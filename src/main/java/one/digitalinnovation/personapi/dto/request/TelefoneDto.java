package one.digitalinnovation.personapi.dto.request;

import com.sun.istack.NotNull;
import lombok.*;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType tipo;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String numero;
}
