package dev.patika.fifthhomeworkemredalci.controller;



import dev.patika.fifthhomeworkemredalci.dto.StudentRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.StudentResponseDTO;
import dev.patika.fifthhomeworkemredalci.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/find-all-students")
    public List<StudentResponseDTO> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/find-by-name")
    public StudentResponseDTO findByName(String name) {
        return studentService.findByName(name);
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(long id){
        studentService.deleteById(id);
    }

    @PostMapping("/save-student")
    public StudentResponseDTO save(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        return studentService.save(studentRequestDTO);
    }

    @PutMapping("/update-student")
    public StudentResponseDTO update(@RequestBody @Valid StudentResponseDTO studentResponseDTO) {
        return studentService.update(studentResponseDTO);
    }

}
