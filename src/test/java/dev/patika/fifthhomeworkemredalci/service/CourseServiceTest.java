package dev.patika.fifthhomeworkemredalci.service;

import dev.patika.fifthhomeworkemredalci.dto.CourseRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.CourseResponseDTO;
import dev.patika.fifthhomeworkemredalci.exception.CourseIsAlreadyExistException;
import dev.patika.fifthhomeworkemredalci.exception.EntityNotFoundException;
import dev.patika.fifthhomeworkemredalci.exception.StudentNumberForOneCourseExceedException;
import dev.patika.fifthhomeworkemredalci.mapper.CourseMapper;
import dev.patika.fifthhomeworkemredalci.model.Course;
import dev.patika.fifthhomeworkemredalci.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    CourseRepository courseRepository;

    @Mock
    CourseMapper courseMapper;

    @InjectMocks
    CourseService courseService;

    @Test
    void findAll() {
        //given
        List<Course> listOfCourse = new ArrayList<>();
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        when(courseRepository.findAll()).thenReturn(listOfCourse);
        //lenient().when(courseMapper.mapFromCoursetoCourseResponseDTO(any())).thenReturn(courseResponseDTO);

        //when
        List<Course> actual = courseService.findAll().stream().map(courseMapper::mapFromCourseResponseDTOtoCourse).collect(Collectors.toList());
        //then
        assertAll(
                () -> assertEquals(listOfCourse,actual),
                () -> assertNotNull(actual)
        );
    }

    @Test
    void findByName() {
        //given
        Course course = new Course();
        CourseResponseDTO expected = new CourseResponseDTO();
        when(courseRepository.findByCourseName(anyString())).thenReturn(Optional.of(course));
        when(courseMapper.mapFromCoursetoCourseResponseDTO(any())).thenReturn(expected);
        expected=courseMapper.mapFromCoursetoCourseResponseDTO(course);
        //when
        String name = "Algorithms";
        CourseResponseDTO actual =courseService.findByName(name);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );
    }

    @Test
    void save() {
        //given
        Course course = new Course();
        CourseResponseDTO expected = new CourseResponseDTO();
        when(courseRepository.existsByCourseCode(anyString())).thenReturn(Boolean.FALSE);
        when(courseMapper.mapFromCourseRequestDTOtoCourse(any())).thenReturn(course);
        when(courseRepository.save(any())).thenReturn(course);
        when(courseMapper.mapFromCoursetoCourseResponseDTO(any())).thenReturn(expected);

        //when
        CourseRequestDTO dto = new CourseRequestDTO();
        Set<Long> studentIds = new HashSet<>();
        studentIds.add(1L);
        studentIds.add(2L);
        dto.setStudentIds(studentIds);
        dto.setCourseCode("ABC");
        CourseResponseDTO actual = courseService.save(dto);
        //then
        assertAll(
                () -> assertNotNull(expected),
                () -> assertNotNull(actual),
                () -> assertEquals(expected,actual)
        );
    }



    @Test
    void update() {
        //given
        Course course = new Course();
        Course mappedCourse = new Course();
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
        when(courseMapper.mapFromCourseResponseDTOtoCourse(any())).thenReturn(mappedCourse);
        when(courseRepository.save(any())).thenReturn(mappedCourse);
        //when
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        CourseResponseDTO actual=courseService.update(courseResponseDTO);
        //then
        assertAll(
                () -> assertNotNull(actual)
        );
    }

    @Test
    void should_ThrowEntityNotFoundException_WhenEntityDoesntExist(){
        assertThrows(EntityNotFoundException.class,() -> courseService.findByName(anyString()));
    }

    @Test
    void should_ThrowCourseIsAlreadyExistException_WhenCourseCodeIsExist(){
        when(courseRepository.existsByCourseCode(anyString())).thenReturn(Boolean.TRUE);
        CourseRequestDTO requestDTO = new CourseRequestDTO();
        requestDTO.setCourseCode("ABC");
        assertThrows(CourseIsAlreadyExistException.class,()-> courseService.save(requestDTO));
    }

    @Test
    void should_ThrowStudentNumberForOneCourseExceedException_WhenStudentSizeGreaterThanTwenty(){
        CourseRequestDTO requestDTO = new CourseRequestDTO();
        Set<Long> ids = new HashSet<>();
        for (long i =1;i <40;i++){
            ids.add(i);
        }
        requestDTO.setStudentIds(ids);
        assertThrows(StudentNumberForOneCourseExceedException.class,() -> courseService.save(requestDTO));
    }
}