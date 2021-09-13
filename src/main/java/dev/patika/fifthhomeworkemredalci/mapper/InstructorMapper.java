package dev.patika.fifthhomeworkemredalci.mapper;



import dev.patika.fifthhomeworkemredalci.dto.*;
import dev.patika.fifthhomeworkemredalci.model.Instructor;
import dev.patika.fifthhomeworkemredalci.model.PermanentInstructor;
import dev.patika.fifthhomeworkemredalci.model.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper
public interface InstructorMapper {



    PermanentInstructor mapFromPermanentInstructorRequestDTOtoPermanentInstructor(PermanentInstructorRequestDTO permanentInstructorRequestDTO);
    PermanentInstructorResponseDTO mapFromPermanentInstructortoPermanentInstructorResponseDTO(PermanentInstructor permanentInstructor);
    PermanentInstructor mapFromPermanentInstructorResponseDTOtoPermanentInstructor(PermanentInstructorResponseDTO permanentInstructorResponseDTO);


    VisitingResearcher mapFromVisitingResearcherRequestDTOtoVisitingResearcher(VisitingResearcherRequestDTO visitingResearcherRequestDTO);
    VisitingResearcherResponseDTO mapFromVisitingResearchertoVisitingResearcherResponseDTO(VisitingResearcher visitingResearcher);
    VisitingResearcher mapFromVisitingResearherResponseDTOtoVisitingResearcher(VisitingResearcherResponseDTO visitingResearcherResponseDTO);


    Instructor mapFromInstructorResponseDTOtoInstructor(InstructorResponseDTO instructorResponseDTO);
    InstructorResponseDTO mapFromInstructortoInstructorResponseDTO(Instructor instructor);






}
