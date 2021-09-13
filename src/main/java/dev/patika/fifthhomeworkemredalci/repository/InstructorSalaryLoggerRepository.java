package dev.patika.fifthhomeworkemredalci.repository;

import dev.patika.fifthhomeworkemredalci.model.InstructorSalaryLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorSalaryLoggerRepository extends JpaRepository<InstructorSalaryLogger,Long> {


    List<InstructorSalaryLogger> findByInstructorId(long id);
    List<InstructorSalaryLogger> findByCreatedTime(LocalDate date);
}
