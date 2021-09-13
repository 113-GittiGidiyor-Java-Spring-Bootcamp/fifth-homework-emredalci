package dev.patika.fifthhomeworkemredalci.mapper;


import dev.patika.fifthhomeworkemredalci.dto.StudentRequestDTO;
import dev.patika.fifthhomeworkemredalci.dto.StudentResponseDTO;
import dev.patika.fifthhomeworkemredalci.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student mapFromStudentRequestDTOtoStudent(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO mapFromStudenttoStudentResponseDTO(Student student);
    Student mapFromStudentResponseDTOtoStudent(StudentResponseDTO studentResponseDTO);

}
