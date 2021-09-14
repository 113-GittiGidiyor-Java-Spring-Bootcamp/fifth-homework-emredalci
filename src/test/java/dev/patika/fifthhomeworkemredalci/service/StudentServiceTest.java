package dev.patika.fifthhomeworkemredalci.service;

import dev.patika.fifthhomeworkemredalci.dto.StudentRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.StudentResponseDTO;
import dev.patika.fifthhomeworkemredalci.exception.EntityNotFoundException;
import dev.patika.fifthhomeworkemredalci.exception.StudentAgeNotValidException;
import dev.patika.fifthhomeworkemredalci.exception.StudentIsAlreadyExistException;
import dev.patika.fifthhomeworkemredalci.mapper.StudentMapper;
import dev.patika.fifthhomeworkemredalci.model.Student;
import dev.patika.fifthhomeworkemredalci.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    StudentMapper studentMapper;

    @InjectMocks
    StudentService studentService;


    @Test
    void findAll() {
        //when
        List<Student> listOfStudent = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(listOfStudent);

        //given
        List<Student> actual = studentService.findAll().stream().map(studentMapper::mapFromStudentResponseDTOtoStudent).collect(Collectors.toList());

        //then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(listOfStudent,actual)

        );
    }

    @Test
    void findByName() {
        //given
        Student student = new Student();
        StudentResponseDTO expected = new StudentResponseDTO();
        when(studentRepository.findByName(anyString())).thenReturn(Optional.of(student));
        when(studentMapper.mapFromStudenttoStudentResponseDTO(any())).thenReturn(expected);
        expected =studentMapper.mapFromStudenttoStudentResponseDTO(student);

        //when
        String name ="Emre";
        StudentResponseDTO actual =studentService.findByName(name);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );



    }

    @Test
    void save() {
        //given
        Student student = new Student();
        //student.setBirthDate(LocalDate.of(2000,01,01));
        StudentResponseDTO expected = new StudentResponseDTO();
        when(studentRepository.existsByNameAndBirthDate(anyString(),any())).thenReturn(Boolean.FALSE);
        when(studentMapper.mapFromStudentRequestDTOtoStudent(any())).thenReturn(student);
        when(studentRepository.save(any())).thenReturn(student);
        when(studentMapper.mapFromStudenttoStudentResponseDTO(any())).thenReturn(expected);
        //when
        StudentRequestDTO dto = new StudentRequestDTO();
        dto.setBirthDate(LocalDate.of(2000,01,01));
        dto.setName("Emre");
        StudentResponseDTO actual =this.studentService.save(dto);
        //then
        assertAll(
                () -> assertNotNull(expected),
                () -> assertNotNull(actual),
                ()-> assertEquals(expected,actual)
        );
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
        //given
        Student student = new Student();
        Student mappedStudent = new Student();
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        when(studentMapper.mapFromStudentResponseDTOtoStudent(any())).thenReturn(mappedStudent);
        when(studentRepository.save(any())).thenReturn(mappedStudent);
        //when
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        StudentResponseDTO actual =studentService.update(studentResponseDTO);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );

    }

    @Test
    void findAllIds() {
        //given
        Student student = new Student();
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        //when
        Set<Long> studentIds = new HashSet<>();
        studentIds.add(1L);
        Set<Student> actual =studentService.findAllIds(studentIds);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );
    }

    @Test
    void should_ThrowStudentAgeNotValidException_WhenStudentAgeIsNotValid(){
        StudentRequestDTO requestDTO = new StudentRequestDTO();
        requestDTO.setBirthDate(LocalDate.of(1000,01,01));
        assertThrows(StudentAgeNotValidException.class,()->studentService.save(requestDTO));
    }

    @Test
    void should_ThrowStudentIsAlreadyExistException_WhenAlreadyIsExist(){
        StudentRequestDTO requestDTO = new StudentRequestDTO();
        requestDTO.setBirthDate(LocalDate.of(2000,01,01));
        requestDTO.setName("ABC");
        when(studentRepository.existsByNameAndBirthDate(requestDTO.getName(),requestDTO.getBirthDate())).thenReturn(Boolean.TRUE);
        assertThrows(StudentIsAlreadyExistException.class,()-> studentService.save(requestDTO));
    }

    @Test
    void should_ThrowEntityNotFoundException_WhenEntityDoesntExist(){
        assertThrows(EntityNotFoundException.class,() -> studentService.deleteById(1L));
    }

    @Test
    void should_ThrowEntityNotFoundException_WhenEntityDoesntExist2(){
        Set<Long> ids =new HashSet<>();
        ids.add(1L);
        ids.add(2L);
        assertThrows(EntityNotFoundException.class,() -> studentService.findAllIds(ids));
    }


}