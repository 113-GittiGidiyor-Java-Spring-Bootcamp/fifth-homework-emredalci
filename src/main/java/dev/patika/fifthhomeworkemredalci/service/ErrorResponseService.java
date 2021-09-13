package dev.patika.fifthhomeworkemredalci.service;



import dev.patika.fifthhomeworkemredalci.dto.ErrorResponseDTO;
import dev.patika.fifthhomeworkemredalci.mapper.ErrorResponseMapper;
import dev.patika.fifthhomeworkemredalci.model.ErrorResponse;
import dev.patika.fifthhomeworkemredalci.repository.ErrorResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ErrorResponseService {

    private final ErrorResponseRepository errorResponseRepository;
    private final ErrorResponseMapper errorResponseMapper;


    /** Save error response to database. User can not reach save operation. So dont have to use DTO.
     *
     * @param errorResponse
     * @return ApplicationErrorResponse
     */
    public ErrorResponse save(ErrorResponse errorResponse){
        return errorResponseRepository.save(errorResponse);
    }

    /** Order by created date error responses
     *
     * @return ErrorResponseDTO
     */
    public List<ErrorResponseDTO> orderByCreatedDataDesc(){
        return  errorResponseRepository.findAllByOrderByCreatedDateDesc()
                .stream()
                .map(errorResponseMapper::mapFromErrorResponsetoErrorResponseDTO)
                .collect(Collectors.toList());

    }

    /** Represent error response by status code
     *
     * @param status
     * @return ErrorResponseDTO
     */
    public List<ErrorResponseDTO> findAllByStatus(int status){
        return errorResponseRepository.findAllByStatus(status)
                .stream()
                .map(errorResponseMapper::mapFromErrorResponsetoErrorResponseDTO)
                .collect(Collectors.toList());
    }



}
