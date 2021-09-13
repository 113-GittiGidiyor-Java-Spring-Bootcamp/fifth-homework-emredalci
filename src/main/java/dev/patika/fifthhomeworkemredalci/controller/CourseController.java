package dev.patika.fifthhomeworkemredalci.controller;



import dev.patika.fifthhomeworkemredalci.dto.CourseRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.CourseResponseDTO;
import dev.patika.fifthhomeworkemredalci.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/find-all")
    public ResponseEntity<List<CourseResponseDTO>> findAllCourses(){
        return new ResponseEntity<>(courseService.findAll(),HttpStatus.OK);
    }


    @GetMapping("/find-by-name")
    public CourseResponseDTO findByName(String name) {
        return courseService.findByName(name);
    }


    @DeleteMapping("/delete-by-id")
    public void deleteById(long id){
        courseService.deleteById(id);
    }



    @PostMapping("/save-course")
    public ResponseEntity<CourseResponseDTO> saveCourse(@RequestBody @Valid CourseRequestDTO courseRequestDTO){
        return new ResponseEntity<>(courseService.save(courseRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public CourseResponseDTO update(@RequestBody @Valid CourseResponseDTO CourseResponseDTO) {
        return courseService.update(CourseResponseDTO);
    }

}
