package dev.patika.fifthhomeworkemredalci.repository;


import dev.patika.fifthhomeworkemredalci.model.ErrorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorResponseRepository extends JpaRepository<ErrorResponse,Integer> {

    List<ErrorResponse> findAllByOrderByCreatedDateDesc();
    List<ErrorResponse> findAllByStatus(int status);
}
