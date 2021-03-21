package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PessoaDto;
import one.digitalinnovation.personapi.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toModel(PessoaDto pessoaDto);

    PessoaDto toDTO(Pessoa pessoa);
}
