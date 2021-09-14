package dev.patika.fifthhomeworkemredalci.service;


import dev.patika.fifthhomeworkemredalci.dto.*;
import dev.patika.fifthhomeworkemredalci.exception.EntityNotFoundException;
import dev.patika.fifthhomeworkemredalci.exception.InstructorIsAlreadyExistException;
import dev.patika.fifthhomeworkemredalci.mapper.InstructorMapper;
import dev.patika.fifthhomeworkemredalci.model.Instructor;
import dev.patika.fifthhomeworkemredalci.model.InstructorSalaryLogger;
import dev.patika.fifthhomeworkemredalci.model.PermanentInstructor;
import dev.patika.fifthhomeworkemredalci.model.VisitingResearcher;
import dev.patika.fifthhomeworkemredalci.model.enumeration.UpdateSalaryType;
import dev.patika.fifthhomeworkemredalci.repository.InstructorRepository;
import dev.patika.fifthhomeworkemredalci.repository.InstructorSalaryLoggerRepository;
import dev.patika.fifthhomeworkemredalci.util.ClientRequestInfo;
import dev.patika.fifthhomeworkemredalci.util.MessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorService implements BaseService<InstructorResponseDTO>{

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final InstructorSalaryLoggerRepository instructorSalaryLoggerRepository;


    private final ClientRequestInfo clientRequestInfo;

    /** Represent all InstructorResponseDTOs
     *
     * @return InstructorDTO
     */
    @Override
    public List<InstructorResponseDTO> findAll() {
        return instructorRepository.findAll()
                .stream().map(instructorMapper::mapFromInstructortoInstructorResponseDTO)
                .collect(Collectors.toList());
    }

    /** Represent InstructorResponseDTO by instructor name
     *
     * @param instructorName
     * @return InstructorDTO
     */
    @Override
    public InstructorResponseDTO findByName(String instructorName) {
        return instructorRepository.findByName(instructorName)
                .map(instructorMapper::mapFromInstructortoInstructorResponseDTO).get();
    }

    /** save PermanentInstructor using PermanentInstructorRequestDTO
     *
     * @param permanentInstructorRequestDTO
     * @return PermanentInstructorDTO
     */
    public PermanentInstructorResponseDTO savePermentInstructor(PermanentInstructorRequestDTO permanentInstructorRequestDTO) {
        if(instructorRepository.existsByNameAndPhoneNumber(permanentInstructorRequestDTO.getName(),permanentInstructorRequestDTO.getPhoneNumber())){
            throw new InstructorIsAlreadyExistException(MessageConstants.ENTITY_ALREADY_EXIST);
        }else {
            PermanentInstructor permanentInstructor =
                    instructorMapper.mapFromPermanentInstructorRequestDTOtoPermanentInstructor(permanentInstructorRequestDTO);


            instructorRepository.save(permanentInstructor);

            PermanentInstructorResponseDTO permanentInstructorResponseDTO
                    = instructorMapper.mapFromPermanentInstructortoPermanentInstructorResponseDTO(permanentInstructor);


            return permanentInstructorResponseDTO;
        }

    }

    /** save VisitingResearcher using VisitingResearcherRequestDTO
     *
     * @param visitingResearcherRequestDTO
     * @return VisitingResearcherDTO
     */
    public VisitingResearcherResponseDTO saveVisitingResearcher(VisitingResearcherRequestDTO visitingResearcherRequestDTO) {
        if(instructorRepository.existsByNameAndPhoneNumber(visitingResearcherRequestDTO.getName(),visitingResearcherRequestDTO.getPhoneNumber())){
            throw new InstructorIsAlreadyExistException(MessageConstants.ENTITY_ALREADY_EXIST);
        }else {
            VisitingResearcher visitingResearcher =
                    instructorMapper.mapFromVisitingResearcherRequestDTOtoVisitingResearcher(visitingResearcherRequestDTO);


            instructorRepository.save(visitingResearcher);

            VisitingResearcherResponseDTO visitingResearcherResponseDTO =
                    instructorMapper.mapFromVisitingResearchertoVisitingResearcherResponseDTO(visitingResearcher);

            return visitingResearcherResponseDTO;

        }

    }


    /** Delete instructor using id
     *
     * @param id
     */
    @Override
    public void deleteById(long id) {
        if(!instructorRepository.findById(id).isPresent()){
            throw new EntityNotFoundException(MessageConstants.ENTITY_NOT_FOUND);
        }else {
            instructorRepository.deleteById(id);
            System.out.println(MessageConstants.ENTITY_DELETED);
        }
    }

    /** Update Permanent Instructor using PermanentInstructorResponseDTO.We use PermanentInstructorResponseDTO
     * for id
     *
     * @param permanentInstructorResponseDTO
     * @return
     */

    public PermanentInstructorResponseDTO updatePermanentInstructor(@RequestBody @Valid PermanentInstructorResponseDTO permanentInstructorResponseDTO) {
        PermanentInstructor permanentInstructor
                = (PermanentInstructor) instructorRepository.findById(permanentInstructorResponseDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageConstants.ENTITY_NOT_FOUND));
        PermanentInstructor mappedPermanentInstructor = instructorMapper.mapFromPermanentInstructorResponseDTOtoPermanentInstructor(permanentInstructorResponseDTO);
        mappedPermanentInstructor.setId(permanentInstructorResponseDTO.getId());
        instructorRepository.save(mappedPermanentInstructor);
        return permanentInstructorResponseDTO;
    }

    /** Update Visiting Researcher using VisitingResearcherResponseDTO. We use VisitingResearcherResponseDTO
     * for id
     *
     * @param visitingResearcherResponseDTO
     * @return
     */
    public VisitingResearcherResponseDTO updateVisitingResearcher(@RequestBody @Valid VisitingResearcherResponseDTO visitingResearcherResponseDTO){
        VisitingResearcher visitingResearcher =
                (VisitingResearcher) instructorRepository.findById(visitingResearcherResponseDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException(MessageConstants.ENTITY_NOT_FOUND));
        VisitingResearcher mappedVisitingResearcher = instructorMapper.mapFromVisitingResearherResponseDTOtoVisitingResearcher(visitingResearcherResponseDTO);
        mappedVisitingResearcher.setId(visitingResearcherResponseDTO.getId());
        instructorRepository.save(mappedVisitingResearcher);
        return visitingResearcherResponseDTO;
    }

    /** Represent instructor by id
     *
     * @param id
     * @return Instructor
     */
    public Instructor findById(long id){
        return instructorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(MessageConstants.ENTITY_NOT_FOUND));
    }


    private void saveInstructorSalaryLoggerToDatabase(Instructor instructor,double salaryBefore,
                                                      double salaryAfter,double amount,UpdateSalaryType updateSalaryType){
        InstructorSalaryLogger instructorSalaryLogger = new InstructorSalaryLogger();
        instructorSalaryLogger.setInstructorId(instructor.getId());
        instructorSalaryLogger.setSalaryBefore(salaryBefore);
        instructorSalaryLogger.setSalaryAfter(salaryAfter);
        instructorSalaryLogger.setSalaryRate(amount);
        instructorSalaryLogger.setUpdateSalaryType(updateSalaryType);
        instructorSalaryLogger.setCreatedTime(LocalDate.now());
        instructorSalaryLogger.setClientUrl(clientRequestInfo.getClientUrl());
        instructorSalaryLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        instructorSalaryLogger.setSessionActivityId(clientRequestInfo.getSessionActivity());
        instructorSalaryLoggerRepository.save(instructorSalaryLogger);

    }

    /** Update instructor salary.
     *
     * @param id
     * @param updateSalaryType
     * @param amount
     * @return
     */
    public InstructorRequestDTO updateInstructorSalary(long id, UpdateSalaryType updateSalaryType, double amount) {
        Instructor instructor = instructorRepository.findById(id).get();
        if(instructor.getClass()==PermanentInstructor.class){
            PermanentInstructor permanentInstructor = (PermanentInstructor) instructor;
            if(updateSalaryType.equals(UpdateSalaryType.INCREASE)){
                double salaryBefore = permanentInstructor.getFixedSalary();
                double salaryAfter = permanentInstructor.getFixedSalary() +
                        permanentInstructor.getFixedSalary()*amount/100;
                permanentInstructor.setFixedSalary(salaryAfter);
                instructorRepository.save(permanentInstructor);
                this.saveInstructorSalaryLoggerToDatabase(permanentInstructor,salaryBefore,
                        salaryAfter,amount,updateSalaryType);
                return instructorMapper.mapFromPermanentInstructortoPermanentInstructorResponseDTO(permanentInstructor);

            }else {
                double salaryBefore = permanentInstructor.getFixedSalary();
                double salaryAfter = permanentInstructor.getFixedSalary() -
                        permanentInstructor.getFixedSalary()*amount/100;
                permanentInstructor.setFixedSalary(salaryAfter);
                instructorRepository.save(permanentInstructor);
                this.saveInstructorSalaryLoggerToDatabase(permanentInstructor,salaryBefore,
                        salaryAfter,amount,updateSalaryType);
                return instructorMapper.mapFromPermanentInstructortoPermanentInstructorResponseDTO(permanentInstructor);
            }

        }else {
            VisitingResearcher visitingResearcher = (VisitingResearcher) instructor;
            if(updateSalaryType.equals(UpdateSalaryType.INCREASE)){
                double salaryBefore = visitingResearcher.getHourlySalary();
                double salaryAfter = visitingResearcher.getHourlySalary() +
                        visitingResearcher.getHourlySalary()*amount/100;
                visitingResearcher.setHourlySalary(salaryAfter);
                instructorRepository.save(visitingResearcher);
                this.saveInstructorSalaryLoggerToDatabase(visitingResearcher,salaryBefore,salaryAfter,
                        amount,updateSalaryType);
                return instructorMapper.mapFromVisitingResearchertoVisitingResearcherResponseDTO(visitingResearcher);

            }else{
                double salaryBefore = visitingResearcher.getHourlySalary();
                double salaryAfter = visitingResearcher.getHourlySalary() -
                        visitingResearcher.getHourlySalary()*amount/100;
                visitingResearcher.setHourlySalary(salaryAfter);
                instructorRepository.save(visitingResearcher);
                this.saveInstructorSalaryLoggerToDatabase(visitingResearcher,salaryBefore,salaryAfter,
                        amount,updateSalaryType);
                return instructorMapper.mapFromVisitingResearchertoVisitingResearcherResponseDTO(visitingResearcher);

            }
        }


    }

    /** Find instructor loggers by instructor id
     *
     * @param id
     * @return
     */
    public List<InstructorSalaryLogger> findLoggerById(long id){
        return instructorSalaryLoggerRepository.findByInstructorId(id);
    }

    /** Find instructor loggers by date
     *
     * @param date
     * @return
     */
    public List<InstructorSalaryLogger> findLoggerByDate(LocalDate date){
        return instructorSalaryLoggerRepository.findByCreatedTime(date);
    }
}
