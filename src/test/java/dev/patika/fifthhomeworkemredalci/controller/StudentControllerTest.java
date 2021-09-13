package dev.patika.fifthhomeworkemredalci.controller;

import dev.patika.fifthhomeworkemredalci.dto.StudentResponseDTO;
import dev.patika.fifthhomeworkemredalci.service.StudentService;
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
class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void findAll() {
        //given
        List<StudentResponseDTO> expected = new ArrayList<>();
        when(studentService.findAll()).thenReturn(expected);
        //when
        List<StudentResponseDTO> actual = studentController.findAll();
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void findByName() {
        //given
        StudentResponseDTO expected = new StudentResponseDTO();
        when(studentService.findByName(anyString())).thenReturn(expected);
        //when
        StudentResponseDTO actual=studentController.findByName(anyString());
        //test
        assertAll(
                ()-> assertEquals(expected,actual)
        );
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
        //given
        StudentResponseDTO expected = new StudentResponseDTO();
        when(studentService.save(any())).thenReturn(expected);
        //when
        StudentResponseDTO actual=studentController.save(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void update() {
        //given
        StudentResponseDTO expected = new StudentResponseDTO();
        when(studentService.update(any())).thenReturn(expected);
        //when
        StudentResponseDTO actual=studentController.update(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }
}