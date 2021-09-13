package dev.patika.fifthhomeworkemredalci.controller;

import dev.patika.fifthhomeworkemredalci.dto.InstructorRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.InstructorResponseDTO;
import dev.patika.fifthhomeworkemredalci.dto.PermanentInstructorResponseDTO;
import dev.patika.fifthhomeworkemredalci.dto.VisitingResearcherResponseDTO;
import dev.patika.fifthhomeworkemredalci.model.InstructorSalaryLogger;
import dev.patika.fifthhomeworkemredalci.repository.CourseRepository;
import dev.patika.fifthhomeworkemredalci.repository.InstructorSalaryLoggerRepository;
import dev.patika.fifthhomeworkemredalci.service.InstructorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class InstructorControllerTest {

    @Mock
    InstructorService instructorService;



    @InjectMocks
    InstructorController instructorController;



    @Test
    void findAll() {
        //when
        List<InstructorResponseDTO> expected = new ArrayList<>();
        when(instructorService.findAll()).thenReturn(expected);
        //given
        List<InstructorResponseDTO> actual =instructorController.findAll();
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void findByName() {
        //when
        InstructorResponseDTO expected = new InstructorResponseDTO();
        when(instructorService.findByName(anyString())).thenReturn(expected);
        //given
        InstructorResponseDTO actual=instructorController.findByName(anyString());
        //then
        assertAll(
                ()-> assertEquals(expected,actual)
        );
    }

    @Test
    void savePermentInstructor() {
        //when
        PermanentInstructorResponseDTO expected = new PermanentInstructorResponseDTO();
        when(instructorService.savePermentInstructor(any())).thenReturn(expected);
        //given
        PermanentInstructorResponseDTO actual =instructorController.savePermentInstructor(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void saveVisitingResearcher() {
        //when
        VisitingResearcherResponseDTO expected = new VisitingResearcherResponseDTO();
        when(instructorService.saveVisitingResearcher(any())).thenReturn(expected);
        //given
        VisitingResearcherResponseDTO actual = instructorController.saveVisitingResearcher(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void deleteById() {
    }

    @Test
    void updatePermanentInstructor() {
        //when
        PermanentInstructorResponseDTO expected = new PermanentInstructorResponseDTO();
        when(instructorService.updatePermanentInstructor(any())).thenReturn(expected);
        //given
        PermanentInstructorResponseDTO actual =instructorController.updatePermanentInstructor(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void updateVisitingResearcher() {
        //when
        VisitingResearcherResponseDTO expected = new VisitingResearcherResponseDTO();
        when(instructorService.updateVisitingResearcher(any())).thenReturn(expected);
        //given
        VisitingResearcherResponseDTO actual =instructorController.updateVisitingResearcher(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void updateSalary() {
        //when
        InstructorRequestDTO expected = new InstructorRequestDTO();
        when(instructorService.updateInstructorSalary(anyLong(),any(),anyDouble())).thenReturn(expected);
        //given
        InstructorRequestDTO actual =instructorController.updateSalary(anyLong(),any(),anyDouble()).getBody();
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void findLoggerById() {
        //when
        List<InstructorSalaryLogger> expected = new ArrayList<>();
        when(instructorService.findLoggerById(anyLong())).thenReturn(expected);
        //given
        List<InstructorSalaryLogger> actual=instructorController.findLoggerById(anyLong()).getBody();
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );

    }

    @Test
    void findLoggerByDate() {
        //when
        List<InstructorSalaryLogger> expected = new ArrayList<>();
        when(instructorService.findLoggerByDate(any())).thenReturn(expected);
        //given
        List<InstructorSalaryLogger> actual=instructorController.findLoggerByDate(any()).getBody();
        //then
        assertAll(
                ()-> assertEquals(expected,actual)
        );
    }
}