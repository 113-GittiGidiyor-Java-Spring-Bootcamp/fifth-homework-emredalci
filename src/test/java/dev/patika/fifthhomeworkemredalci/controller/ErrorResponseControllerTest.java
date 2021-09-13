package dev.patika.fifthhomeworkemredalci.controller;

import dev.patika.fifthhomeworkemredalci.dto.ErrorResponseDTO;
import dev.patika.fifthhomeworkemredalci.service.ErrorResponseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ErrorResponseControllerTest {

    @Mock
    ErrorResponseService errorResponseService;

    @InjectMocks
    ErrorResponseController errorResponseController;



    @Test
    void orderByCreatedDataDesc() {
        //when
        List<ErrorResponseDTO> expected = new ArrayList<>();
        when(errorResponseService.orderByCreatedDataDesc()).thenReturn(expected);
        //given
        List<ErrorResponseDTO> actual=errorResponseController.orderByCreatedDataDesc();
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void findAllByStatus() {
        //when
        List<ErrorResponseDTO> expected = new ArrayList<>();
        when(errorResponseService.findAllByStatus(anyInt())).thenReturn(expected);
        //given
        List<ErrorResponseDTO> actual=errorResponseController.findAllByStatus(anyInt());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }
}