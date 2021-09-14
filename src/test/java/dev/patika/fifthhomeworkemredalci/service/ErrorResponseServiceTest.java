package dev.patika.fifthhomeworkemredalci.service;

import dev.patika.fifthhomeworkemredalci.mapper.ErrorResponseMapper;
import dev.patika.fifthhomeworkemredalci.model.ErrorResponse;
import dev.patika.fifthhomeworkemredalci.repository.ErrorResponseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ErrorResponseServiceTest {

    @Mock
    ErrorResponseRepository errorResponseRepository;

    @Mock
    ErrorResponseMapper errorResponseMapper;

    @InjectMocks
    ErrorResponseService errorResponseService;


    @Test
    void save() {
        //given
        ErrorResponse errorResponse = new ErrorResponse();
        when(errorResponseRepository.save(any())).thenReturn(errorResponse);
        //when
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Message");
        response.setId(1L);
        response.setStatus(400);
        response.setCreatedDate(Instant.now());
        response.setLastModifiedDate(Instant.now());
        ErrorResponse actual=errorResponseService.save(response);
        //then
        assertAll(
                () -> assertEquals(errorResponse,actual)
        );
    }

    @Test
    void orderByCreatedDataDesc() {
        //given
        List<ErrorResponse> error = new ArrayList<>();
        when(errorResponseRepository.findAllByOrderByCreatedDateDesc()).thenReturn(error);
        //when
        List<ErrorResponse> actual =errorResponseService.orderByCreatedDataDesc().stream().map(errorResponseMapper::mapFromErrorResponseDTOtoErrorResponse).collect(Collectors.toList());

        //then
        assertAll(
                () -> assertEquals(error,actual),
                () -> assertNotNull(actual)
        );

    }

    @Test
    void findAllByStatus() {
        //given
        List<ErrorResponse> error = new ArrayList<>();
        when(errorResponseRepository.findAllByStatus(anyInt())).thenReturn(error);
        //when
        List<ErrorResponse> actual=errorResponseService.findAllByStatus(400).stream().map(errorResponseMapper::mapFromErrorResponseDTOtoErrorResponse).collect(Collectors.toList());
        //then
        assertAll(
                () -> assertEquals(error,actual),
                () -> assertNotNull(actual)
        );
    }
}