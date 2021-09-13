package dev.patika.fifthhomeworkemredalci.mapper;


import dev.patika.fifthhomeworkemredalci.dto.ErrorResponseDTO;
import dev.patika.fifthhomeworkemredalci.model.ErrorResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ErrorResponseMapper {


    ErrorResponseDTO mapFromErrorResponsetoErrorResponseDTO(ErrorResponse errorResponse);
}
