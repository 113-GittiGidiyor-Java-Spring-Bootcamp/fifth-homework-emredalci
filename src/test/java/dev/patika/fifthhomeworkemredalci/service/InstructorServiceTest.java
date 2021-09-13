package dev.patika.fifthhomeworkemredalci.service;

import dev.patika.fifthhomeworkemredalci.dto.InstructorResponseDTO;
import dev.patika.fifthhomeworkemredalci.mapper.InstructorMapper;
import dev.patika.fifthhomeworkemredalci.model.Instructor;
import dev.patika.fifthhomeworkemredalci.repository.InstructorRepository;
import dev.patika.fifthhomeworkemredalci.repository.InstructorSalaryLoggerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

    @Mock
    InstructorRepository instructorRepository;

    @Mock
    InstructorMapper instructorMapper;

    @Mock
    InstructorSalaryLoggerRepository instructorSalaryLoggerRepository;

    @InjectMocks
    InstructorService instructorService;

    @Test
    void findAll() {
        //given
        List<Instructor> listOfInstructor = new ArrayList<>();
        when(instructorRepository.findAll()).thenReturn(listOfInstructor);
        //when
        List<Instructor> actual =instructorService.findAll().stream().map(instructorMapper::mapFromInstructorResponseDTOtoInstructor).collect(Collectors.toList());

        //then
        assertAll(
                ()-> assertEquals(listOfInstructor,actual),
                () -> assertNotNull(actual)
        );
    }

    @Test
    void findByName() {
    }

    @Test
    void savePermentInstructor() {
    }

    @Test
    void saveVisitingResearcher() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updatePermanentInstructor() {
    }

    @Test
    void updateVisitingResearcher() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateInstructorSalary() {
    }

    @Test
    void findLoggerById() {
    }

    @Test
    void findLoggerByDate() {
    }
}