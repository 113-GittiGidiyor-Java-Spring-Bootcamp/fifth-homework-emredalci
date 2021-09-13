package dev.patika.fifthhomeworkemredalci.controller;

import dev.patika.fifthhomeworkemredalci.dto.CourseResponseDTO;
import dev.patika.fifthhomeworkemredalci.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    CourseService courseService;

    @InjectMocks
    CourseController courseController;


    @Test
    void findAllCourses() {
        //given
        List<CourseResponseDTO> expected = new ArrayList<>();
        when(courseService.findAll()).thenReturn(expected);
        //when
        ResponseEntity<List<CourseResponseDTO>> actual = courseController.findAllCourses();
        //then
        assertAll(
                () -> assertEquals(expected,actual.getBody())

        );
    }

    @Test
    void findByName() {
        //given
        CourseResponseDTO expected = new CourseResponseDTO();
        when(courseService.findByName(anyString())).thenReturn(expected);
        //when
        CourseResponseDTO actual =courseController.findByName(anyString());
        //then
        assertAll(
                ()-> assertEquals(expected,actual)
        );
    }

    @Test
    void deleteById() {
        //given


        //when
        //then
    }

    @Test
    void saveCourse() {
        //given
        CourseResponseDTO expected = new CourseResponseDTO();
        when(courseService.save(any())).thenReturn(expected);
        //when
        ResponseEntity<CourseResponseDTO> actual =courseController.saveCourse(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual.getBody())
        );
    }

    @Test
    void update() {
        //given
        CourseResponseDTO expected = new CourseResponseDTO();
        when(courseService.update(any())).thenReturn(expected);
        //when
        CourseResponseDTO actual = courseController.update(any());
        //then
        assertAll(
                () -> assertEquals(expected,actual)
        );
    }
}