package dev.patika.fifthhomeworkemredalci.service;

import dev.patika.fifthhomeworkemredalci.dto.*;
import dev.patika.fifthhomeworkemredalci.mapper.InstructorMapper;
import dev.patika.fifthhomeworkemredalci.model.Course;
import dev.patika.fifthhomeworkemredalci.model.Instructor;
import dev.patika.fifthhomeworkemredalci.model.PermanentInstructor;
import dev.patika.fifthhomeworkemredalci.model.VisitingResearcher;
import dev.patika.fifthhomeworkemredalci.model.enumeration.UpdateSalaryType;
import dev.patika.fifthhomeworkemredalci.repository.InstructorRepository;
import dev.patika.fifthhomeworkemredalci.repository.InstructorSalaryLoggerRepository;
import dev.patika.fifthhomeworkemredalci.util.ClientRequestInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    ClientRequestInfo clientRequestInfo;


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
        //given
        Instructor instructor = new Instructor();
        InstructorResponseDTO expected = new InstructorResponseDTO();
        when(instructorRepository.findByName(anyString())).thenReturn(Optional.of(instructor));
        when(instructorMapper.mapFromInstructortoInstructorResponseDTO(any())).thenReturn(expected);
        expected=instructorMapper.mapFromInstructortoInstructorResponseDTO(instructor);
        //when
        String name = "Emre";
        InstructorResponseDTO actual =instructorService.findByName(name);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );
    }

    @Test
    void savePermentInstructor() {
        //given
        PermanentInstructor permanentInstructor = new PermanentInstructor();
        PermanentInstructorResponseDTO expeted = new PermanentInstructorResponseDTO();
        when(instructorRepository.existsByNameAndPhoneNumber(anyString(),anyString())).thenReturn(Boolean.FALSE);
        when(instructorMapper.mapFromPermanentInstructorRequestDTOtoPermanentInstructor(any())).thenReturn(permanentInstructor);
        when(instructorRepository.save(any())).thenReturn(permanentInstructor);
        when(instructorMapper.mapFromPermanentInstructortoPermanentInstructorResponseDTO(any())).thenReturn(expeted);

        //when
        PermanentInstructorRequestDTO dto = new PermanentInstructorRequestDTO();
        dto.setName("Emre");
        dto.setPhoneNumber("11111111111");
        PermanentInstructorResponseDTO actual=instructorService.savePermentInstructor(dto);

        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expeted,actual)
        );
    }

    @Test
    void saveVisitingResearcher() {
        VisitingResearcher visitingResearcher = new VisitingResearcher();
        VisitingResearcherResponseDTO expected = new VisitingResearcherResponseDTO();
        when(instructorRepository.existsByNameAndPhoneNumber(anyString(),anyString())).thenReturn(Boolean.FALSE);
        when(instructorMapper.mapFromVisitingResearcherRequestDTOtoVisitingResearcher(any())).thenReturn(visitingResearcher);
        when(instructorRepository.save(any())).thenReturn(visitingResearcher);
        when(instructorMapper.mapFromVisitingResearchertoVisitingResearcherResponseDTO(any())).thenReturn(expected);

        //when
        VisitingResearcherRequestDTO dto = new VisitingResearcherRequestDTO();
        dto.setName("Emre");
        dto.setPhoneNumber("11111111111");
        VisitingResearcherResponseDTO actual=instructorService.saveVisitingResearcher(dto);

        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected,actual)
        );
    }

    @Test
    void deleteById() {
    }

    @Test
    void updatePermanentInstructor() {
        PermanentInstructor permanentInstructor = new PermanentInstructor();
        PermanentInstructor mappedPermanentInstructor = new PermanentInstructor();
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(permanentInstructor));
        when(instructorMapper.mapFromPermanentInstructorResponseDTOtoPermanentInstructor(any())).thenReturn(mappedPermanentInstructor);
        when(instructorRepository.save(any())).thenReturn(mappedPermanentInstructor);
        //when
        PermanentInstructorResponseDTO dto = new PermanentInstructorResponseDTO();
        PermanentInstructorResponseDTO actual=instructorService.updatePermanentInstructor(dto);
        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(permanentInstructor.getId(),actual.getId())
        );
    }

    @Test
    void updateVisitingResearcher() {
        VisitingResearcher visitingResearcher = new VisitingResearcher();
        VisitingResearcher mappedVisitingReasearcher = new VisitingResearcher();
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(visitingResearcher));
        when(instructorMapper.mapFromVisitingResearherResponseDTOtoVisitingResearcher(any())).thenReturn(mappedVisitingReasearcher);
        when(instructorRepository.save(any())).thenReturn(mappedVisitingReasearcher);
        //when
        VisitingResearcherResponseDTO dto = new VisitingResearcherResponseDTO();
        VisitingResearcherResponseDTO actual=instructorService.updateVisitingResearcher(dto);
        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(visitingResearcher.getId(),actual.getId())
        );
    }

    @Test
    void findById() {
        //given
        Instructor instructor = new Instructor();
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(instructor));
        //when
        Instructor actual=instructorService.findById(1L);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );

    }

    @Test
    void updateInstructorSalary() {
        //given
        Instructor instructor = new Instructor();
        PermanentInstructor permanentInstructor = new PermanentInstructor();
        PermanentInstructorResponseDTO permanentInstructorResponseDTO = new PermanentInstructorResponseDTO();
        VisitingResearcherResponseDTO visitingResearcherResponseDTO = new VisitingResearcherResponseDTO();
        when(instructorRepository.findById(anyLong())).thenReturn(Optional.of(permanentInstructor));
        when(instructorRepository.save(any())).thenReturn(instructor);
        when(instructorMapper.mapFromPermanentInstructortoPermanentInstructorResponseDTO(any())).thenReturn(permanentInstructorResponseDTO);
        when(instructorMapper.mapFromVisitingResearchertoVisitingResearcherResponseDTO(any())).thenReturn(visitingResearcherResponseDTO);
        //when
        Instructor ins = new Instructor();
        ins.setId(1L);
        clientRequestInfo.setClientUrl("123");
        clientRequestInfo.setClientIpAddress("123");
        clientRequestInfo.setSessionActivity("123456");
        InstructorRequestDTO actual =instructorService.updateInstructorSalary(1L, UpdateSalaryType.INCREASE,50);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );
    }

    @Test
    void findLoggerById() {
    }

    @Test
    void findLoggerByDate() {
    }
}