package dev.patika.fifthhomeworkemredalci.controller;


import dev.patika.fifthhomeworkemredalci.dto.*;
import dev.patika.fifthhomeworkemredalci.model.InstructorSalaryLogger;
import dev.patika.fifthhomeworkemredalci.model.enumeration.UpdateSalaryType;
import dev.patika.fifthhomeworkemredalci.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/find-all")
    public List<InstructorResponseDTO> findAll(){
        return instructorService.findAll();
    }

    @GetMapping("/find-by-name")
    public InstructorResponseDTO findByName(String instructorName){
        return instructorService.findByName(instructorName);
    }

    @PostMapping("/save-permanent-instructor")
    public PermanentInstructorResponseDTO savePermentInstructor(@RequestBody @Valid PermanentInstructorRequestDTO permanentInstructorRequestDTO) {
        return instructorService.savePermentInstructor(permanentInstructorRequestDTO);
    }

    @PostMapping("/save-visiting-researcher")
    public VisitingResearcherResponseDTO saveVisitingResearcher(@RequestBody @Valid VisitingResearcherRequestDTO visitingResearcherRequestDTO) {
        return instructorService.saveVisitingResearcher(visitingResearcherRequestDTO);
    }

    @DeleteMapping("/delete-by-id")
    public void deleteById(long id){
        instructorService.deleteById(id);
    }


    @PutMapping("/update-permanent-instructor")
    public PermanentInstructorResponseDTO updatePermanentInstructor(@RequestBody @Valid PermanentInstructorResponseDTO permanentInstructorResponseDTO){
        return instructorService.updatePermanentInstructor(permanentInstructorResponseDTO);
    }

    @PutMapping("/update-visiting-researcher")
    public VisitingResearcherResponseDTO updateVisitingResearcher(@RequestBody @Valid VisitingResearcherResponseDTO visitingResearcherResponseDTO){
        return instructorService.updateVisitingResearcher(visitingResearcherResponseDTO);
    }

    @PutMapping("/update-salary")
    public ResponseEntity<InstructorRequestDTO> updateSalary(@RequestParam long id, @RequestParam UpdateSalaryType updateSalaryType,@RequestParam double amount){
        return ResponseEntity.ok(instructorService.updateInstructorSalary(id,updateSalaryType,amount));
        //return new ResponseEntity<>("Salary updated", HttpStatus.OK);
    }

    @GetMapping("/instructorLoggerByInstructorId")
    public ResponseEntity<List<InstructorSalaryLogger>> findLoggerById(@RequestParam long id){
        return ResponseEntity.ok(instructorService.findLoggerById(id));
    }

    @GetMapping("/instructorLoggerByDate")
    public ResponseEntity<List<InstructorSalaryLogger>> findLoggerByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date){
        return ResponseEntity.ok(instructorService.findLoggerByDate(date));
    }

}
